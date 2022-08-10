package meli.dh.com.finalmeliproject.mocks;

import com.sun.xml.bind.v2.runtime.reflect.Lister;
import meli.dh.com.finalmeliproject.model.Package;

import java.util.ArrayList;
import java.util.List;

public class GeneratePackage {

    public static Package newPackageToSave() {
        return Package.builder()
                .id(21)
                .packageType("caixa")
                .storageCapacity(10)
                .category(null)
                .build();
    }

    public static List<Package> newListOfPackageToSave() {
        List<Package> listOfPackages = new ArrayList<>();
        Package packages = new Package();

        packages.setId(54);
        packages.setPackageType("saco");
        packages.setStorageCapacity(20);
        packages.setCategory(null);

        listOfPackages.add(packages);

        return listOfPackages;
    }
}
