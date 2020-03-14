package com.stackbuilders.prediction;

import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the \"Pico y Placa\" predictor program");
        System.out.println("You will need to provide some information in order to know if your car can or cannot be on the road");
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Insert the plate:");
            Plate plate = new Plate(scanner.nextLine());
            System.out.println("Insert the date (dd-MM-yyyy):");
            Date date = PicoPlaca.validateDateFormat(scanner.nextLine());
            System.out.println("Insert the time (HH:mm):");
            Date time = PicoPlaca.validateTimeFormat(scanner.nextLine());
            PicoPlaca picoplaca = new PicoPlaca(plate,date,time);
            String prediction = picoplaca.validate();
            System.out.println(prediction);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
