package com.stackbuilders.prediction;

import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class PicoPlacaTest {
    static final String DATE_PATTERN = "dd-MM-yyyy";
    static final String TIME_PATTERN = "HH:mm";

    @Before
    public void setUp() {
    }

    @Test
    public void validateDateFormat() throws ParseException {
        DateFormat formatter = new SimpleDateFormat(PicoPlacaTest.DATE_PATTERN);
        assertEquals(formatter.parse("12-03-2020"), PicoPlaca.validateDateFormat("12-03-2020"));

    }

    @Test(expected = ParseException.class)
    public void exceptionValidateDateFormat() throws Exception {
        PicoPlaca.validateDateFormat("12-25-2020");
    }

    @Test(expected = ParseException.class)
    public void exceptionValidateDateFormat2() throws Exception {
        PicoPlaca.validateDateFormat("anything");
    }

    @Test
    public void validateTimeFormat() throws ParseException {
        DateFormat formatter = new SimpleDateFormat(PicoPlacaTest.TIME_PATTERN);
        assertEquals(formatter.parse("12:30"), PicoPlaca.validateTimeFormat("12:30"));

    }

    @Test(expected = ParseException.class)
    public void exceptionValidateTimeFormat() throws Exception {
        PicoPlaca.validateTimeFormat("50:20");
    }

    @Test(expected = ParseException.class)
    public void exceptionValidateTimeFormat2() throws Exception {
        PicoPlaca.validateTimeFormat("anything");
    }

    @Test
    public void validateMorningRestriction() throws Exception {
        String inputPlate = "hbb1567",
                inputDate = "12-03-2020", //THURSDAY
                inputTime = "08:00";
        Plate plate = new Plate(inputPlate);
        PicoPlaca pp = new PicoPlaca(plate, PicoPlaca.validateDateFormat(inputDate), PicoPlaca.validateTimeFormat(inputTime));
        assertEquals("The car CANNOT be on the road", pp.validate());
    }

    @Test
    public void validateAfternoonRestriction() throws Exception {
        String inputPlate = "hbb1567",
                inputDate = "12-03-2020", //THURSDAY
                inputTime = "17:00";
        Plate plate = new Plate(inputPlate);
        PicoPlaca pp = new PicoPlaca(plate, PicoPlaca.validateDateFormat(inputDate), PicoPlaca.validateTimeFormat(inputTime));
        assertEquals("The car CANNOT be on the road", pp.validate());
    }

    @Test
    public void validateExtremeTimes() throws Exception {
        String inputPlate = "hbb1567",
                inputDate = "12-03-2020", //THURSDAY
                inputTime = "07:00";
        Plate plate = new Plate(inputPlate);
        PicoPlaca pp = new PicoPlaca(plate, PicoPlaca.validateDateFormat(inputDate), PicoPlaca.validateTimeFormat(inputTime));
        assertEquals("The car CANNOT be on the road", pp.validate());
    }

    @Test
    public void validateExtremeTimes2() throws Exception {
        String inputPlate = "hbb1567",
                inputDate = "12-03-2020", //THURSDAY
                inputTime = "09:30";
        Plate plate = new Plate(inputPlate);
        PicoPlaca pp = new PicoPlaca(plate, PicoPlaca.validateDateFormat(inputDate), PicoPlaca.validateTimeFormat(inputTime));
        assertEquals("The car CANNOT be on the road", pp.validate());
    }

    @Test
    public void validateExtremeTimes3() throws Exception {
        String inputPlate = "hbb1567",
                inputDate = "12-03-2020", //THURSDAY
                inputTime = "16:00";
        Plate plate = new Plate(inputPlate);
        PicoPlaca pp = new PicoPlaca(plate, PicoPlaca.validateDateFormat(inputDate), PicoPlaca.validateTimeFormat(inputTime));
        assertEquals("The car CANNOT be on the road", pp.validate());
    }

    @Test
    public void validateExtremeTimes4() throws Exception {
        String inputPlate = "hbb1567",
                inputDate = "12-03-2020", //THURSDAY
                inputTime = "19:30";
        Plate plate = new Plate(inputPlate);
        PicoPlaca pp = new PicoPlaca(plate, PicoPlaca.validateDateFormat(inputDate), PicoPlaca.validateTimeFormat(inputTime));
        assertEquals("The car CANNOT be on the road", pp.validate());
    }

    @Test
    public void validateMorningAllowedTimes() throws Exception {
        String inputPlate = "hbb1567",
                inputDate = "12-03-2020", //THURSDAY
                inputTime = "6:59";
        Plate plate = new Plate(inputPlate);
        PicoPlaca pp = new PicoPlaca(plate, PicoPlaca.validateDateFormat(inputDate), PicoPlaca.validateTimeFormat(inputTime));
        assertEquals("The car CAN be on the road", pp.validate());
    }

    @Test
    public void validateMorningAllowedTimes2() throws Exception {
        String inputPlate = "hbb1567",
                inputDate = "12-03-2020", //THURSDAY
                inputTime = "5:00";
        Plate plate = new Plate(inputPlate);
        PicoPlaca pp = new PicoPlaca(plate, PicoPlaca.validateDateFormat(inputDate), PicoPlaca.validateTimeFormat(inputTime));
        assertEquals("The car CAN be on the road", pp.validate());
    }

    @Test
    public void validateMorningAllowedTimes3() throws Exception {
        String inputPlate = "hbb1567",
                inputDate = "12-03-2020", //THURSDAY
                inputTime = "9:31";
        Plate plate = new Plate(inputPlate);
        PicoPlaca pp = new PicoPlaca(plate, PicoPlaca.validateDateFormat(inputDate), PicoPlaca.validateTimeFormat(inputTime));
        assertEquals("The car CAN be on the road", pp.validate());
    }

    @Test
    public void validateMorningAllowedTimes4() throws Exception {
        String inputPlate = "hbb1567",
                inputDate = "12-03-2020", //THURSDAY
                inputTime = "11:30";
        Plate plate = new Plate(inputPlate);
        PicoPlaca pp = new PicoPlaca(plate, PicoPlaca.validateDateFormat(inputDate), PicoPlaca.validateTimeFormat(inputTime));
        assertEquals("The car CAN be on the road", pp.validate());
    }

    @Test
    public void validateAfternoonAllowedTimes() throws Exception {
        String inputPlate = "hbb1567",
                inputDate = "12-03-2020", //THURSDAY
                inputTime = "15:59";
        Plate plate = new Plate(inputPlate);
        PicoPlaca pp = new PicoPlaca(plate, PicoPlaca.validateDateFormat(inputDate), PicoPlaca.validateTimeFormat(inputTime));
        assertEquals("The car CAN be on the road", pp.validate());
    }

    @Test
    public void validateAfternoonAllowedTimes2() throws Exception {
        String inputPlate = "hbb1567",
                inputDate = "12-03-2020", //THURSDAY
                inputTime = "14:00";
        Plate plate = new Plate(inputPlate);
        PicoPlaca pp = new PicoPlaca(plate, PicoPlaca.validateDateFormat(inputDate), PicoPlaca.validateTimeFormat(inputTime));
        assertEquals("The car CAN be on the road", pp.validate());
    }

    @Test
    public void validateAfternoonAllowedTimes3() throws Exception {
        String inputPlate = "hbb1567",
                inputDate = "12-03-2020", //THURSDAY
                inputTime = "19:31";
        Plate plate = new Plate(inputPlate);
        PicoPlaca pp = new PicoPlaca(plate, PicoPlaca.validateDateFormat(inputDate), PicoPlaca.validateTimeFormat(inputTime));
        assertEquals("The car CAN be on the road", pp.validate());
    }

    @Test
    public void validateAfternoonAllowedTimes4() throws Exception {
        String inputPlate = "hbb1567",
                inputDate = "12-03-2020", //THURSDAY
                inputTime = "20:30";
        Plate plate = new Plate(inputPlate);
        PicoPlaca pp = new PicoPlaca(plate, PicoPlaca.validateDateFormat(inputDate), PicoPlaca.validateTimeFormat(inputTime));
        assertEquals("The car CAN be on the road", pp.validate());
    }

    @Test
    public void validateAllowedDay() throws Exception {
        String inputPlate = "hbb1567",
                inputDate = "11-03-2020",//WEDNESDAY
                inputTime = "08:30";
        Plate plate = new Plate(inputPlate);
        PicoPlaca pp = new PicoPlaca(plate, PicoPlaca.validateDateFormat(inputDate), PicoPlaca.validateTimeFormat(inputTime));
        assertEquals("The car CAN be on the road", pp.validate());
    }

    @Test
    public void validateAllowedDay2() throws Exception {
        String inputPlate = "hbb1567",
                inputDate = "11-03-2020", //WEDNESDAY
                inputTime = "17:30";
        Plate plate = new Plate(inputPlate);
        PicoPlaca pp = new PicoPlaca(plate, PicoPlaca.validateDateFormat(inputDate), PicoPlaca.validateTimeFormat(inputTime));
        assertEquals("The car CAN be on the road", pp.validate());
    }


}