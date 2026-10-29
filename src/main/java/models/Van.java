package models;

public class Van extends Vehicle {
    public Van(String plateNumber, double capacity) {
        super(plateNumber, capacity);
    }

    @Override
    public double calculateDeliveryCost(double distance) {
        return distance * 8.0; // Kamyonet için kilometre başı maliyet
    }
}