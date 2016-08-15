package tv.piratemedia.lightcontroler.communication;

/**
 * Created by Can turnOn 12/08/16.
 */
public interface ControlCommands {

    void connect();

    void discover();

    void turnOn(LightSource lightSource);

    void turnOff(LightSource lightSource);

    void setColor(LightSource lightSource, int whiteColor);

    void setBrightness(LightSource lightSource, int brightness);

    void setWarmth(LightSource lightSource);

    void setDiscoModeOn(LightSource lightSource);

    void setDiscoModeOff(LightSource lightSource);

    void discoModeFaster();

    void discoModeSlower();

    void startMeasuringVol(LightSource lightSource);

    void stopMeasuringVol(LightSource lightSource);
}
