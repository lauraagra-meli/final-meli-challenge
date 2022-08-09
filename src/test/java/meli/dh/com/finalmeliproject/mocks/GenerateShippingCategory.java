package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.model.Category;
import meli.dh.com.finalmeliproject.model.Shipping;
import meli.dh.com.finalmeliproject.model.ShippingCategory;

import java.util.ArrayList;
import java.util.List;

public class GenerateShippingCategory {

    public static ShippingCategory newShippingCartToSave() {
        Category category = new Category();
        Shipping shipping = new Shipping();

        return ShippingCategory.builder()
                .id(32)
                .quantityMax(100)
                .category(category)
                .shipping(shipping)
                .build();
    }

    public static List<ShippingCategory> newListOfShippingToSave() {
        Category category = new Category();
        Shipping shipping = new Shipping();

        List<ShippingCategory> shippingCategoryList = new ArrayList<>();
        ShippingCategory shippingCategory = new ShippingCategory();

        shippingCategory.setId(2);
        shippingCategory.setQuantityMax(300);
        shippingCategory.setCategory(category);
        shippingCategory.setShipping(shipping);

        shippingCategoryList.add(shippingCategory);

        return shippingCategoryList;
    }
}
