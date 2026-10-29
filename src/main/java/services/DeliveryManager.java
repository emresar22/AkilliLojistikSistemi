package services;

import interfaces.IDataStorage;
import models.Package;
import models.Vehicle;
import utils.VehicleFactory;

import java.util.ArrayList;
import java.util.List;

public class DeliveryManager {
    private IDataStorage storage;
    private List<Package> packages;
    private List<Vehicle> vehicles;
    private RouteOptimizer optimizer;

    public DeliveryManager(IDataStorage storage) {
        // Dependency Injection (Bağımlılık Enjeksiyonu) ile DIP prensibini uyguluyoruz
        this.storage = storage;
        this.packages = storage.loadPackages();
        this.vehicles = new ArrayList<>();
        this.optimizer = new RouteOptimizer();

        // Sisteme Factory Pattern kullanarak varsayılan iki araç ekliyoruz
        vehicles.add(VehicleFactory.createVehicle("TRUCK", "34 ABC 123", 500.0));
        vehicles.add(VehicleFactory.createVehicle("VAN", "34 DEF 456", 200.0));
    }

    public void addPackage(String id, double weight, String destination) {
        packages.add(new Package(id, weight, destination));
        storage.savePackages(packages); // Veriyi anında txt dosyasına kaydediyoruz
        System.out.println("Paket başarıyla eklendi ve kalıcı olarak kaydedildi.");
    }

    public void optimizeAndLoad() {
        if (packages.isEmpty()) {
            System.out.println("Dağıtılacak paket bulunmuyor.");
            return;
        }
        // Örnek olarak ilk araca (Kamyon) Knapsack algoritması ile yükleme yapıyoruz
        optimizer.optimizeLoading(vehicles.get(0), packages);
    }

    public void listPackages() {
        if (packages.isEmpty()) {
            System.out.println("Sistemde kayıtlı paket yok.");
            return;
        }
        for(Package p : packages) {
            System.out.println("ID: " + p.getId() + " | Ağırlık: " + p.getWeight() + " kg | Hedef: " + p.getDestination());
        }
    }
}