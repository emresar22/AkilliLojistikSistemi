import models.Package;
import models.Truck;
import models.Van;
import models.Vehicle;
import utils.VehicleFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LojistikSistemiTest {

    @Test
    void testPackageCreation() {
        Package pkg = new Package("P01", 30.5, "Istanbul");
        assertEquals("P01", pkg.getId());
        assertEquals(30.5, pkg.getWeight());
        assertEquals("Istanbul", pkg.getDestination());
        assertFalse(pkg.isDelivered());
    }

    @Test
    void testPackageDeliveryStatus() {
        Package pkg = new Package("P02", 10.0, "Ankara");
        pkg.setDelivered(true);
        assertTrue(pkg.isDelivered());
    }

    @Test
    void testVehicleFactoryCreatesTruck() {
        Vehicle truck = VehicleFactory.createVehicle("TRUCK", "34 ABC 123", 500.0);
        assertTrue(truck instanceof Truck);
        assertEquals("34 ABC 123", truck.getPlateNumber());
        assertEquals(500.0, truck.getCapacity());
    }

    @Test
    void testVehicleFactoryCreatesVan() {
        Vehicle van = VehicleFactory.createVehicle("VAN", "06 DEF 456", 200.0);
        assertTrue(van instanceof Van);
        assertEquals("06 DEF 456", van.getPlateNumber());
        assertEquals(200.0, van.getCapacity());
    }

    @Test
    void testVehicleFactoryThrowsExceptionForInvalidType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            VehicleFactory.createVehicle("MOTORCYCLE", "35 GHI 789", 50.0);
        });
        assertEquals("Bilinmeyen araç tipi: MOTORCYCLE", exception.getMessage());
    }

    @Test
    void testTruckDeliveryCost() {
        Vehicle truck = new Truck("34 TRK 01", 1000.0);
        double cost = truck.calculateDeliveryCost(100.0);
        assertEquals(1500.0, cost); // 100 km * 15.0
    }

    @Test
    void testVanDeliveryCost() {
        Vehicle van = new Van("34 VAN 01", 300.0);
        double cost = van.calculateDeliveryCost(100.0);
        assertEquals(800.0, cost); // 100 km * 8.0
    }

    @Test
    void testVehicleLoadsPackageSuccessfully() {
        Vehicle truck = new Truck("34 TRK 02", 100.0);
        Package pkg = new Package("P03", 40.0, "Izmir");

        boolean isLoaded = truck.loadPackage(pkg);
        assertTrue(isLoaded);
        assertEquals(40.0, truck.getCurrentLoad());
    }

    @Test
    void testVehicleFailsToLoadPackageExceedingCapacity() {
        Vehicle van = new Van("34 VAN 02", 50.0);
        Package pkg1 = new Package("P04", 40.0, "Bursa");
        Package pkg2 = new Package("P05", 20.0, "Edirne");

        assertTrue(van.loadPackage(pkg1)); // İlk paket yüklenir (40kg)
        assertFalse(van.loadPackage(pkg2)); // İkinci paket kapasiteyi aşar (40+20 > 50)
        assertEquals(40.0, van.getCurrentLoad()); // Sadece ilk paketin ağırlığı kalır
    }
}