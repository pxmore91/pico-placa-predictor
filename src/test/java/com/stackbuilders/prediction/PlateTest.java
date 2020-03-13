package com.stackbuilders.prediction;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlateTest {

    @Test
    public void setGetPlate() throws PlateException {
        String inputPlate = "abc123";
        Plate plate = new Plate(inputPlate);
        assertEquals("ABC123",plate.getFullPlate());
    }

    @Test
    public void setGetPlate2() throws PlateException {
        String inputPlate = "abc1234";
        Plate plate = new Plate(inputPlate);
        assertEquals("ABC1234",plate.getFullPlate());
    }

    @Test
    public void getLastNumber() throws PlateException {
        String inputPlate = "ABC1234";
            Plate plate = new Plate(inputPlate);
            assertEquals(4,plate.getLastNumber());
    }

    @Test
    public void getLastNumber2() throws PlateException {
        String inputPlate = "ABC123";
        Plate plate = new Plate(inputPlate);
        assertEquals(9,plate.getLastNumber());
    }

    @Test (expected = PlateException.class)
    public void testPlateException() throws PlateException {
        String inputPlate = "anything";
        Plate plate = new Plate(inputPlate);
    }

    @Test (expected = PlateException.class)
    public void testPlateException2() throws PlateException {
        String inputPlate = "ABCD1234";
        Plate plate = new Plate(inputPlate);
    }

    @Test (expected = PlateException.class)
    public void testPlateException3() throws PlateException {
        String inputPlate = "AB1234";
        Plate plate = new Plate(inputPlate);
    }

    @Test (expected = PlateException.class)
    public void testPlateException4() throws PlateException {
        String inputPlate = "ABC12345";
        Plate plate = new Plate(inputPlate);
    }

    @Test (expected = PlateException.class)
    public void testPlateException5() throws PlateException {
        String inputPlate = "ABC12";
        Plate plate = new Plate(inputPlate);
    }

    @Test (expected = PlateException.class)
    public void testPlateException6() throws PlateException {
        String inputPlate = "A1";
        Plate plate = new Plate(inputPlate);
    }



}