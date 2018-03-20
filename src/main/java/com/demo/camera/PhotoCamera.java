package com.demo.camera;

public class PhotoCamera implements WriteListener {

    private boolean OnOf;
    ImageSensor sensor;
    Card karta;
    boolean zapis = false;


    public PhotoCamera() {

        OnOf = false;
    }


    public PhotoCamera(ImageSensor sensor) {

        OnOf = false;
        this.sensor = sensor;

    }

    public PhotoCamera(ImageSensor sensor, Card karta) {

        OnOf = false;
        this.sensor = sensor;
        this.karta = karta;

    }


    public void turnOn() {

        OnOf = true;
        sensor.turnOn();

    }

    public void turnOff() {

        OnOf = false;
        sensor.turnOff();

    }

    public void pressButton() {


        if (OnOf) {


            while (!zapis) {
                karta.write(sensor.read());

            }

        }
    }


        public boolean isOnOf () {
            return OnOf;
        }

        public void setOnOf ( boolean onOf){
            OnOf = onOf;
        }

        @Override
        public void writeCompleted () {

            zapis = true;

        }

}

