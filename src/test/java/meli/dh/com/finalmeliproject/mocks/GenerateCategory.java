package meli.dh.com.finalmeliproject.mocks;

import com.sun.xml.bind.v2.runtime.reflect.Lister;
import meli.dh.com.finalmeliproject.model.*;
import meli.dh.com.finalmeliproject.model.Package;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GenerateCategory {

    public static Category newCategoryToSave() {
        List<ShippingCategory> shippingCategoryList = new ArrayList<>();
        shippingCategoryList.add(new ShippingCategory(1, 100, null, null));
        List<Package> packageList = new ArrayList<>();
        packageList.add(new Package(1, "caixa", 200, null));
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("MELI02193", "banana", 12, null, null, LocalDate.of(2023, 02, 15), LocalDateTime.now()));
        List<InboundOrder> inboundOrderList = new ArrayList<>();
        inboundOrderList.add(new InboundOrder(1, LocalDateTime.now(), null, null, null));

        return Category.builder()
                .id(1)
                .categoryName("fresco")
                .minTemperature(15)
                .maxTemperature(25)
                .build();
    }
}
