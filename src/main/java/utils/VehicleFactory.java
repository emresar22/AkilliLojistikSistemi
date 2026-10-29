package utils;

import models.Truck;
import models.Van;
import models.Vehicle;

public class VehicleFactory {
    public static Vehicle createVehicle(String type, String plateNumber, double capacity) {
        if (type.equalsIgnoreCase("TRUCK")) {
            return new Truck(plateNumber, capacity);
        } else if (type.equalsIgnoreCase("VAN")) {
            return new Van(plateNumber, capacity);
        }
        throw new IllegalArgumentException("Bilinmeyen araç tipi: " + type);
    }
}