package interfaces;

import java.util.List;
import models.Package;

public interface IDataStorage {
    void savePackages(List<Package> packages);
    List<Package> loadPackages();
}