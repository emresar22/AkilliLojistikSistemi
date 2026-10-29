package models;

public class Package {
    private String id;
    private double weight;
    private String destination;
    private boolean isDelivered;

    public Package(String id, double weight, String destination) {
        this.id = id;
        this.weight = weight;
        this.destination = destination;
        this.isDelivered = false;
    }

    public String getId() { return id; }
    public double getWeight() { return weight; }
    public String getDestination() { return destination; }
    public boolean isDelivered() { return isDelivered; }
    public void setDelivered(boolean delivered) { isDelivered = delivered; }
}