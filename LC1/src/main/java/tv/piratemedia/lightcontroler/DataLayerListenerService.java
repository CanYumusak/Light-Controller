package tv.piratemedia.lightcontroler;


import android.util.Log;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

import tv.piratemedia.lightcontroler.communication.UDPControlCommands;

/*
Created by Harry Sibenaler (mrwhale)
*/

public class DataLayerListenerService extends WearableListenerService {
    private static final String TAG = "DataLayer";

    @Override
    //On message received event, does an action when the handheld app receives a message from the watch
    public void onMessageReceived(MessageEvent messageEvent) {
        super.onMessageReceived(messageEvent);
        // if ("/MESSAGE".equals(messageEvent.getPath())) {
        // Create a new controller instance so we can send commands to the wifi controller
        Log.d(TAG, "message received" + messageEvent.getPath());
        controller mCont = new controller();
        UDPControlCommands cmd;
        cmd = new UDPControlCommands(this, mCont.mHandler);
        //A switch to find out what message was sent from the watch
        switch (messageEvent.getPath()){
            case "/0":
                if (!cmd.appState.getOnOff(5)) {
                    cmd.turnOn(5);
                    cmd.appState.setOnOff(5, true);
                    Log.d(TAG, "lights in w.zone 1 on");
                }
                else if (cmd.appState.getOnOff(5)){
                    cmd.turnOff(5);
                    cmd.appState.setOnOff(5, false);
                    Log.d(TAG, "lights in w.zone 1 off");
                }
                break;
            case "/1":
                if (!cmd.appState.getOnOff(6)) {
                    cmd.turnOn(6);
                    cmd.appState.setOnOff(6, true);
                    Log.d(TAG, "lights in w.zone 2 on");
                }
                else if (cmd.appState.getOnOff(6)){
                    cmd.turnOff(6);
                    cmd.appState.setOnOff(6, false);
                    Log.d(TAG, "lights in w.zone 2 off");
                }
                break;
            case "/2":
                if (!cmd.appState.getOnOff(7)) {
                    cmd.turnOn(7);
                    cmd.appState.setOnOff(7, true);
                    Log.d(TAG, "lights in w.zone 3 on");
                }
                else if (cmd.appState.getOnOff(7)){
                    cmd.turnOff(7);
                    cmd.appState.setOnOff(7, false);
                    Log.d(TAG, "lights in w.zone 3 off");
                }
                break;
            case "/3":
                if (!cmd.appState.getOnOff(8)) {
                    cmd.turnOn(8);
                    cmd.appState.setOnOff(8, true);
                    Log.d(TAG, "lights in w.zone 4 on");
                }
                else if (cmd.appState.getOnOff(8)){
                    cmd.turnOff(8);
                    cmd.appState.setOnOff(8, false);
                    Log.d(TAG, "lights in w.zone 4 off");
                }
                break;
            case "/4":
                if (!cmd.appState.getOnOff(1)) {
                    cmd.turnOn(1);
                    cmd.appState.setOnOff(1, true);
                    Log.d(TAG, "lights in rgbw zone 1 on");
                }
                else if (cmd.appState.getOnOff(1)){
                    cmd.turnOff(1);
                    cmd.appState.setOnOff(1, false);
                    Log.d(TAG, "lights in rgbw zone 1 off");
                }
                break;
            case "/5":
                if (!cmd.appState.getOnOff(2)) {
                    cmd.turnOn(2);
                    cmd.appState.setOnOff(2, true);
                    Log.d(TAG, "lights in rgbw zone 2 on");
                }
                else if (cmd.appState.getOnOff(2)){
                    cmd.turnOff(2);
                    cmd.appState.setOnOff(2, false);
                    Log.d(TAG, "lights in rgbw zone 2 off");
                }
                break;
            case "/6":
                if (!cmd.appState.getOnOff(3)) {
                    cmd.turnOn(3);
                    cmd.appState.setOnOff(3, true);
                    Log.d(TAG, "lights in rgbw zone 3 on");
                }
                else if (cmd.appState.getOnOff(3)){
                    cmd.turnOff(3);
                    cmd.appState.setOnOff(3, false);
                    Log.d(TAG, "lights in rgbw zone 3 off");
                }
                break;
            case "/7":
                if (!cmd.appState.getOnOff(4)) {
                    cmd.turnOn(4);
                    cmd.appState.setOnOff(4, true);
                    Log.d(TAG, "lights in rgbw zone 4 on");
                }
                else if (cmd.appState.getOnOff(4)){
                    cmd.turnOff(4);
                    cmd.appState.setOnOff(4, false);
                    Log.d(TAG, "lights in rgbw zone 4 off");
                }
                break;
        }

    //}
    }
}
