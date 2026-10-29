package services;

import models.Package;
import models.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class RouteOptimizer {

    // 0/1 Knapsack Algoritması ile araca kapasitesini aşmadan maksimum ağırlıkta paket yükleme
    public void optimizeLoading(Vehicle vehicle, List<Package> availablePackages) {
        int n = availablePackages.size();
        int capacity = (int) vehicle.getCapacity();

        // Dinamik Programlama (DP) Matrisi
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            int weight = (int) availablePackages.get(i - 1).getWeight();
            for (int w = 1; w <= capacity; w++) {
                if (weight <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight] + weight);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Seçilen paketleri bulmak için Backtracking (Geri İzleme)
        int res = dp[n][capacity];
        int w = capacity;
        List<Package> loadedPackages = new ArrayList<>();

        for (int i = n; i > 0 && res > 0; i--) {
            if (res != dp[i - 1][w]) {
                Package selectedPkg = availablePackages.get(i - 1);
                loadedPackages.add(selectedPkg);
                vehicle.loadPackage(selectedPkg);
                res = res - (int) selectedPkg.getWeight();
                w = w - (int) selectedPkg.getWeight();
            }
        }

        System.out.println(vehicle.getPlateNumber() + " plakalı araca " + loadedPackages.size() + " adet paket optimum şekilde yüklendi.");
    }
}