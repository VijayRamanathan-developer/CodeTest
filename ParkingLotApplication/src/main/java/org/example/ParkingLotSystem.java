package org.example;

import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ParkingLotSystem {
    public static void main(String[] args) throws IOException {

        ParkingLot parkingLot = null;
        BufferedReader reader;

        if (args.length > 0) {
            reader = new BufferedReader(new FileReader(args[0]));
        } else {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        String line;
        while((line = reader.readLine()) != null) {
            String[] command = line.split(" ");
            switch (command[0]) {
                case "create_parking_lot":
                    parkingLot = new ParkingLot(Integer.parseInt(command[1]));
                    break;

                case "park":
                    if (parkingLot != null) parkingLot.park(command[1], command[2]);
                    break;

                case "leave":
                    if (parkingLot != null) parkingLot.leave(Integer.parseInt(command[1]));
                    break;

                case "status":
                    if (parkingLot != null) parkingLot.status();
                    break;

                case "registration_numbers_for_cars_with_colour":
                    if (parkingLot != null) parkingLot.regNumForColor(command[1]);
                    break;

                case "slot_numbers_for_cars_with_colour":
                    if (parkingLot != null) parkingLot.slotForColor(command[1]);
                    break;

                case "slot_number_for_registration_number":
                    if (parkingLot != null) parkingLot.slotForRegNumber(command[1]);
                    break;

                case "exit":
                    return;

                default:
                    System.out.println("Invalid command");
            }
        }

    }
}