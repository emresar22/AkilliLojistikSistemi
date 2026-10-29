package models;

public abstract class Vehicle {
    private String plateNumber;
    private double capacity;
    private double currentLoad;

    public Vehicle(String plateNumber, double capacity) {
        this.plateNumber = plateNumber;
        this.capacity = capacity;
        this.currentLoad = 0;
    }

    // Çok biçimlilik (Polymorphism) için soyut metot
    public abstract double calculateDeliveryCost(double distance);

    public boolean loadPackage(Package pkg) {
        if (currentLoad + pkg.getWeight() <= capacity) {
            currentLoad += pkg.getWeight();
            return true;
        }
        return false; // Kapasite aşıldı
    }

    public String getPlateNumber() { return plateNumber; }
    public double getCapacity() { return capacity; }
    public double getCurrentLoad() { return currentLoad; }
}