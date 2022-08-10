package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.model.Shipping;
import meli.dh.com.finalmeliproject.model.ShippingCategory;

import java.util.ArrayList;
import java.util.List;

public class GenerateShipping {

    public static Shipping newShippingToSave() {
        List<ShippingCategory> shippingCategoryList = new ArrayList<>();
        shippingCategoryList.add(new ShippingCategory(1, 100, null, null));

        return Shipping.builder()
                .id(1)
                .shippingCapacity(200)
                .shippingCategoryList(shippingCategoryList)
                .build();
    }
}
