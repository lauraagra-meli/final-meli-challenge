package meli.dh.com.finalmeliproject.util;

import meli.dh.com.finalmeliproject.model.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GenerateProduct {

    public static Product newProductToSave() {
        return Product.builder()
                .id("MELI1203921")
                .name("maçã pera")
                .quantity(10)
                .category(GenerateCategory.newCategoryToSave())
                .batch(GenerateBatch.newBatchToSave())
                .dueDate(LocalDate.of(2023,2,12))
                .manufacturingDate(LocalDateTime.of(2022, 12, 15, 10, 23, 12))
                .build();
    }

    public static List<Product> newListProductToSave() {
        List<Product> listOfProducts = new ArrayList<>();
        Product product = new Product();
        product.setId("MELI34242");
        product.setName("banana");
        product.setQuantity(20);
        product.setCategory(GenerateCategory.newCategoryToSave());
        product.setBatch(GenerateBatch.newBatchToSave());
        product.setDueDate(LocalDate.of(2023,2,12));
        product.setManufacturingDate(LocalDateTime.of(2022, 12, 15, 10, 32, 12));
        listOfProducts.add(product);

        return listOfProducts;
    }
}
