package tv.piratemedia.lightcontroler.communication;

import java.util.List;

/**
 * Created by Can 12/08/16.
 */

public class Lights {

    public static final int WHITE_COLOR = 0xFFFFFF;
    private final ControlCommands commands;
    List<LightSource> lightSources;

    public Lights(ControlCommands commands) {
        this.commands = commands;
    }

    void discoverLightSources() {
        commands.discover();
    }

    void turnOn(final LightSource lightSource) {
        commands.turnOn(lightSource);
    }

    void turnOn() {
        for (LightSource lightSource : lightSources) {
            commands.turnOn(lightSource);
        }
    }

    void turnOff(final LightSource lightSource) {
        commands.turnOff(lightSource);
    }

    void turnOff() {
        for (LightSource lightSource : lightSources) {
            commands.turnOff(lightSource);
        }
    }

    void setToWhite(final LightSource lightSource) {
        commands.setColor(lightSource, WHITE_COLOR);
    }
//
//    void setBrightnessUpOne() {
//
//    }
//
//    void setBrightnessDownOne() {
//
//    }

    void setWarmthUpOne() {

    }

    void setWarmthDownOne() {

    }

    void setToFull(int zone) {

    }

    void setColorToNight(int zone) {

    }

    void setToNight(int zone) {

    }

    void setBrightness(int zoneid, int brightness) {

    }

    void setColor(int zoneid, int color) {

    }

    void toggleDiscoMode(int zoneid) {

    }

    void discoModeFaster() {

    }

    void discoModeSlower() {

    }

    void startCandleMode(int zone) {

    }

    void stopCandleMode() {

    }

    void startMeasuringVol(int zone) {

    }

    void stopMeasuringVol() {

    }

    public interface Observer {

        public void didDiscoverLightSource();



    }
}
