package tv.piratemedia.lightcontroler.communication;

import android.graphics.Color;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class CandlingThread extends Thread {

        private final LightSource lightSource;
    private final Lights lights;
    private boolean isCandling = true;
        private final int greenChannelStartValue;
        private final int greenChannelEndValue;
        public static final String START_CANDLE_COLOR = "fffc00";
        public static final String END_CANDLE_COLOR = "ff4e00";


        CandlingThread(final Lights lights, final LightSource lightSource) {
            this.lightSource = lightSource;
            this.lights = lights;

            greenChannelStartValue = Integer.parseInt(START_CANDLE_COLOR.substring(2, 4), 16);
            greenChannelEndValue = Integer.parseInt(END_CANDLE_COLOR.substring(2, 4), 16);
        }


        @Override
        public void run() {
            try {
                int i = 0;
                while(isCandling) {
                    Random r = new Random();
                    String newColor = "#ff";
                    if(greenChannelEndValue - greenChannelStartValue == 0) {
                        newColor += Integer.toHexString(greenChannelStartValue);
                    } else {
                        if(greenChannelEndValue - greenChannelStartValue < 0) {
                            newColor += Integer.toHexString(r.nextInt(greenChannelStartValue - (greenChannelEndValue - greenChannelStartValue)));
                        } else {
                            newColor += Integer.toHexString(r.nextInt(greenChannelEndValue - greenChannelStartValue) + greenChannelStartValue);
                        }
                    }
                    if(newColor.length() < 5) {
                        newColor+="f";
                    }
                    newColor += "00";

                    try {
                        lights.setColor(lightSource, Color.parseColor(newColor));
                    } catch(IllegalArgumentException e) {

                    }
                    int sleedTime = r.nextInt(150) + 50;
                    TimeUnit.MILLISECONDS.sleep(sleedTime);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void stopCandling() {
            isCandling = true;
        }
    }