package tv.piratemedia.lightcontroler.communication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Can 12/08/16.
 */

public class Lights {

    public static final int WHITE_COLOR = 0xFFFFFF;
    private static final int NIGHT_COLOR = 0x0F0F0F;
    private final ControlCommands commands;
    List<LightSource> lightSources;

    int globalBrightness = 0;
    private int globalWarmth = 0;
    private Map<LightSource, CandlingThread> candlingThreads = new HashMap<>();

    public Lights(ControlCommands commands) {
        this.commands = commands;
    }

    public void discoverLightSources() {
        commands.discover();
    }

    public void turnOn(final LightSource lightSource) {
        commands.turnOn(lightSource);
    }

    public void turnOn() {
        for (LightSource lightSource : lightSources) {
            commands.turnOn(lightSource);
        }
    }

    public void turnOff(final LightSource lightSource) {
        commands.turnOff(lightSource);
    }

    public void turnOff() {
        for (LightSource lightSource : lightSources) {
            commands.turnOff(lightSource);
        }
    }

    public void setToWhite(final LightSource lightSource) {
        commands.setColor(lightSource, WHITE_COLOR);
    }

    public void setBrightness(final LightSource lightSource, final int brightness) {
        commands.setBrightness(lightSource, brightness);
    }

    public void setBrightnessUpOne() {
        setBrightness(++globalBrightness);
    }

    public void setBrightnessDownOne() {
        setBrightness(--globalBrightness);
    }

    public void setBrightness(int brightness) {
        for (LightSource lightSource : lightSources) {
            setBrightness(lightSource, brightness);
        }
    }

    void setWarmth(int warmth) {
        for(LightSource lightSource : lightSources) {
            setWarmth(lightSource, warmth);
        }
    }

    public void setWarmth(final LightSource lightSource, int warmth) {
        commands.setWarmth(lightSource);
    }

    void setWarmthUpOne() {
        setWarmth(++globalWarmth);
    }

    void setWarmthDownOne() {
        setWarmth(--globalWarmth);
    }

    void setToFull(final LightSource lightSource) {
        setBrightness(lightSource, 255);
        setColor(lightSource, WHITE_COLOR);
    }

    void setColorToNight(final LightSource lightSource) {
        setColor(lightSource, NIGHT_COLOR);
    }

    void setToNight(final LightSource lightSource) {
        setColor(lightSource, NIGHT_COLOR);
    }

    void setColor(final LightSource lightSource, final int color) {
        commands.setColor(lightSource, color);
    }

    void toggleDiscoMode(final LightSource lightSource) {
        commands.toggleDiscoMode(lightSource);
    }

    void discoModeFaster() {
        commands.discoModeFaster();
    }

    void discoModeSlower() {
        commands.discoModeSlower();
    }

    void startCandleMode(final LightSource lightSource) {
        if(candlingThreads.get(lightSource) == null || !candlingThreads.get(lightSource).isAlive()) {
            CandlingThread candlingThread = new CandlingThread(this, lightSource);
            candlingThread.start();
            candlingThreads.put(lightSource, candlingThread);
        }
    }

    void stopCandleMode(final LightSource lightSource) {
        if (candlingThreads.get(lightSource) != null) {
            candlingThreads.get(lightSource).stopCandling();
        }
    }

    void startMeasuringVol(final LightSource lightSource) {
        commands.startMeasuringVol(lightSource);
    }

    void stopMeasuringVol(final LightSource lightSource) {
        commands.stopMeasuringVol(lightSource);
    }

    public interface Observer {

        void didDiscoverLightSource();

    }
}
