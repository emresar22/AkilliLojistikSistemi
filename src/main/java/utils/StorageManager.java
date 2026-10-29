package utils;

import interfaces.IDataStorage;
import models.Package;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StorageManager implements IDataStorage {
    private static final String FILE_NAME = "packages.txt";

    @Override
    public void savePackages(List<Package> packages) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Package pkg : packages) {
                // Verileri virgülle ayırarak txt dosyasına yazıyoruz
                writer.write(pkg.getId() + "," + pkg.getWeight() + "," + pkg.getDestination() + "," + pkg.isDelivered());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Veri kaydedilirken hata oluştu: " + e.getMessage());
        }
    }

    @Override
    public List<Package> loadPackages() {
        List<Package> packages = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    Package pkg = new Package(data[0], Double.parseDouble(data[1]), data[2]);
                    pkg.setDelivered(Boolean.parseBoolean(data[3]));
                    packages.add(pkg);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Henüz kayıtlı veri yok, sıfırdan başlanıyor.");
        } catch (IOException e) {
            System.out.println("Veri okunurken hata oluştu: " + e.getMessage());
        }
        return packages;
    }
}