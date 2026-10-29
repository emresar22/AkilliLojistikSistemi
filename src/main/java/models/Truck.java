package models;

public class Truck extends Vehicle {
    public Truck(String plateNumber, double capacity) {
        super(plateNumber, capacity);
    }

    @Override
    public double calculateDeliveryCost(double distance) {
        return distance * 15.0; // Kamyon için kilometre başı maliyet
    }
}