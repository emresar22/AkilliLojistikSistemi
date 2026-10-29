import services.DeliveryManager;
import utils.StorageManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Sınıfları başlatıyoruz
        StorageManager storageManager = new StorageManager();
        DeliveryManager deliveryManager = new DeliveryManager(storageManager);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== AKILLI LOJİSTİK SİSTEMİ ===");
            System.out.println("1. Yeni Paket Ekle");
            System.out.println("2. Kayıtlı Paketleri Listele");
            System.out.println("3. Araç Yüklemesini Optimize Et (Knapsack)");
            System.out.println("4. Çıkış");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine(); // Scanner buffer temizliği

            if (secim == 1) {
                System.out.print("Paket ID (Örn: P01): ");
                String id = scanner.nextLine();
                System.out.print("Ağırlık (kg): ");
                double weight = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Hedef Şehir: ");
                String dest = scanner.nextLine();

                deliveryManager.addPackage(id, weight, dest);
            } else if (secim == 2) {
                deliveryManager.listPackages();
            } else if (secim == 3) {
                deliveryManager.optimizeAndLoad();
            } else if (secim == 4) {
                System.out.println("Sistemden çıkılıyor. İyi günler!");
                break;
            } else {
                System.out.println("Geçersiz seçim, tekrar deneyin.");
            }
        }
        scanner.close();
    }
}