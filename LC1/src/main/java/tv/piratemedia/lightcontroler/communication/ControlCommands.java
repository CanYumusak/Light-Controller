package tv.piratemedia.lightcontroler.communication;

/**
 * Created by Can turnOn 12/08/16.
 */
public interface ControlCommands {
    int DISCOVERED_DEVICE = 111;
    int LIST_WIFI_NETWORKS = 802;
    int COMMAND_SUCCESS = 222;



    void killUDPC();

    void discover();

    void getWifiNetworks();

    void setWifiNetwork(String SSID, String Security, String Type, String Password);

    void setWifiNetwork(String SSID);

    void turnOn(final LightSource lightSource);

    void turnOnLightSources();

    void turnOff(final LightSource lightSource);

    void turnOffLightSources();

    void setToWhite(final LightSource lightSource);

    void setBrightnessUpOne();

    void setBrightnessDownOne();

    void setWarmthUpOne();

    void setWarmthDownOne();

    void setColorToNight(int zone);

    void setToNight(int zone);

    void setBrightness(int zoneid, int brightness);

    void startTimeout();

    void setColor(final LightSource lightSource, int color);

    void toggleDiscoMode(int zoneid);

    void discoModeFaster();

    void discoModeSlower();

    void startCandleMode(int zone);

    void stopCandleMode();

    void startMeasuringVol(int zone);

    void stopMeasuringVol();
}
