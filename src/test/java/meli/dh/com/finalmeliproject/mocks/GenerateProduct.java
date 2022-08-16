package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.model.Batch;
import meli.dh.com.finalmeliproject.model.Category;
import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.model.Shipping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GenerateProduct {

    public static Product newProductToSave() {
        Category category = new Category();
        Batch batch = new Batch();

        return Product.builder()
                .id("MELI1203921")
                .name("maçã pera")
                .category(category)
                .batch(batch)
                .dueDate(LocalDate.of(2023,2,12))
                .manufacturingDate(LocalDateTime.of(2022, 12, 15, 10, 23, 12))
                .price(1)
                .build();
    }

    public static List<Product> newListProductToSave() {
        List<Product> listOfProducts = new ArrayList<>();
        Category category = new Category();
        Batch batch = new Batch(1, LocalDate.now(), null);

        Product product = new Product();
        product.setId("MELI34242");
        product.setName("banana");
        product.setCategory(category);
        product.setBatch(batch);
        product.setDueDate(LocalDate.of(2023,2,12));
        product.setManufacturingDate(LocalDateTime.of(2022, 12, 15, 10, 32, 12));
        product.setPrice(1);
        listOfProducts.add(product);

        return listOfProducts;
    }
}
