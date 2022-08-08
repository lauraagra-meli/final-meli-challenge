package meli.dh.com.finalmeliproject.util;

import meli.dh.com.finalmeliproject.model.Shipping;

public class GenerateShipping {

    public static Shipping newShippingToSave() {
        return Shipping.builder()
                .id(1)
                .shippingCapacity(200)
                .shippingCategoryList(GenerateShippingCategory.newListOfShippingToSave())
                .build();
    }
}
