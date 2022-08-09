package meli.dh.com.finalmeliproject.util;

import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.model.Shipping;
import meli.dh.com.finalmeliproject.model.ShippingCategory;

import java.util.ArrayList;
import java.util.List;

public class GenerateShippingCategory {

    public static ShippingCategory newShippingCartToSave() {
        return ShippingCategory.builder()
                .id(32)
                .quantityMax(100)
                .category(GenerateCategory.newCategoryToSave())
                .shipping(GenerateShipping.newShippingToSave())
                .build();
    }

    public static List<ShippingCategory> newListOfShippingToSave() {
        List<ShippingCategory> listOfShippingCategory = new ArrayList<>();
        ShippingCategory shippingCategory = new ShippingCategory();

        shippingCategory.setId(2);
        shippingCategory.setQuantityMax(300);
        shippingCategory.setCategory(GenerateCategory.newCategoryToSave());
        shippingCategory.setShipping(GenerateShipping.newShippingToSave());

        listOfShippingCategory.add(shippingCategory);

        return listOfShippingCategory;
    }
}
