package meli.dh.com.finalmeliproject.util;

import meli.dh.com.finalmeliproject.model.Category;

public class GenerateCategory {

    public static Category newCategoryToSave() {
        return Category.builder()
                .id(1)
                .categoryName("fresco")
                .minTemperature(15)
                .maxTemperature(25)
                .shippingCategories(GenerateShippingCategory.newListOfShippingToSave())
                .listOfPackages(GeneratePackage.newListOfPackageToSave())
                .listOfProducts(GenerateProduct.newListProductToSave())
                //.listOfInboundOrder()
                .build();
    }
}
