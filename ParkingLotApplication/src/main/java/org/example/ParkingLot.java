package org.example;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ParkingLot {
    private final int capacity;
    private final TreeSet<Integer> availableSlots;
    private final Map<Integer, Car> parkingLot;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.availableSlots = new TreeSet();
        this.parkingLot = new HashMap<>();
        for (int i = 1; i <= capacity; i++) {
            availableSlots.add(i);
        }

        System.out.println("Created a parking lot with " + capacity + " slots");
    }

    public void park(String regNumber, String color) {

        if(availableSlots.isEmpty()) {
            System.out.println("Sorry, parking lot is full");
            return;
        }
        int slot = availableSlots.pollFirst();
        parkingLot.put(slot, new Car(regNumber, color));
        System.out.println("Allocated slot number : " + slot);
    }

    public void leave(int slot) {
        if(!parkingLot.containsKey(slot)) {
            System.out.println("Slot number " + slot + " is already empty");
            return;
        }
        parkingLot.remove(slot);
        availableSlots.add(slot);
        System.out.println("Slot number " + slot + " is free");
    }

    public void status() {
        System.out.println("Slot No.\tRegistration No\tColour");

        parkingLot.forEach((slot, car) ->
                System.out.println(slot + "\t" + car.getRegNumber() + "\t" + car.getColor()));
    }

    public void regNumForColor(String color) {
        String result = parkingLot.values().stream()
                .filter(car -> car.getColor().equalsIgnoreCase(color))
                .map(Car::getRegNumber)
                .collect(Collectors.joining(", "));
        System.out.println(result.isEmpty() ? "Not found" : result);
    }

    public void slotForColor(String color) {
        String result = parkingLot.entrySet().stream()
                .filter(entry -> entry.getValue().getColor().equalsIgnoreCase(color))
                .map(entry -> String.valueOf(entry.getKey()))
                .collect(Collectors.joining(", "));
        System.out.println(result.isEmpty() ? "Not found" : result);
    }

    public void slotForRegNumber(String regNumber) {
        String result = parkingLot.entrySet().stream()
                .filter(entry -> entry.getValue().getRegNumber().equalsIgnoreCase(regNumber))
                .map(entry -> String.valueOf(entry.getKey()))
                .findFirst()
                .orElse("Not found");
        System.out.println(result);
    }
}
