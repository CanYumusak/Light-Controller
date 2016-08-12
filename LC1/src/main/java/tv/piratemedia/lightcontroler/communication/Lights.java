package tv.piratemedia.lightcontroler.communication;

/**
 * Created by Can 12/08/16.
 */

public class Lights {

    private final ControlCommands commands;

    public Lights(ControlCommands commands) {
        this.commands = commands;
    }

    void discover() {
        commands.discover();
    }

    void turnOn(int zone) {

    }

    void turnOn() {

    }

    void turnOff(int zone) {

    }

    void turnOff() {

    }

    void setToWhite(int zone) {

    }

    void setBrightnessUpOne() {

    }

    void setBrightnessDownOne() {

    }

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

    }
}
