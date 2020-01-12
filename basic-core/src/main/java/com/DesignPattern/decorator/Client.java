package com.DesignPattern.decorator;

import java.io.*;

public class Client {
    public static void main(String[] args) throws FileNotFoundException {
        Car car = new Car();
        car.move();

        System.out.println("****************");
        FLyCar fLyCar = new FLyCar(car);
        fLyCar.move();
        System.out.println("****************");
        WaterCar waterCar = new WaterCar(fLyCar);
        waterCar.move();
        System.out.println("****************");
        AICar aiCar = new AICar(waterCar);
        aiCar.move();

        Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(""))));
    }
}
