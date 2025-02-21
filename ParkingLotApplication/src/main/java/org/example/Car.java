package org.example;

public class Car {
    private final String regNumber;
    private final String color;

    public Car(String regNumber, String color) {
        this.regNumber = regNumber;
        this.color = color;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getColor() {
        return color;
    }
}
