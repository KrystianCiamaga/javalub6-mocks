package com.demo.camera;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PhotoCameraTest {



    @Test
    public void WhenYouTurnOnCameraSensorOn(){

        ImageSensor sensor=mock(ImageSensor.class);
        PhotoCamera camera=new PhotoCamera(sensor);

        camera.turnOn();

        Mockito.verify(sensor).turnOn();

    }


    @Test
    public void WhenYouTurnOffCameraSensorOff(){

        ImageSensor sensor=mock(ImageSensor.class);
        PhotoCamera camera=new PhotoCamera(sensor);

        camera.turnOff();

        Mockito.verify(sensor).turnOff();

    }


   @Test
    public void WhenCameraIsTurnOFFPressButtonDoNothing(){

        ImageSensor sensor=mock(ImageSensor.class);
        PhotoCamera camera=new PhotoCamera(sensor);


        camera.pressButton();

        Mockito.verifyZeroInteractions(sensor);

    }

   @Test
    public void WhenCameraIsOnPressButtonCopy(){

        Card karta=mock(Card.class);
        ImageSensor sensor=mock(ImageSensor.class);

        PhotoCamera camera=new PhotoCamera(sensor,karta);
        camera.turnOn();
        camera.pressButton();

        Mockito.verify(karta).write(Mockito.any());

    }


    @Test
    public void DuringSavingDataTurningOffCameraIsImpossible(){

        Card karta=mock(Card.class);
        ImageSensor sensor=mock(ImageSensor.class);

        PhotoCamera camera=new PhotoCamera(sensor,karta);

        camera.turnOn();
        camera.pressButton();
        camera.turnOff();

        Mockito.verify(sensor).turnOn();

    }





}