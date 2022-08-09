package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.dto.ProductDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GenerateProductDTO {


    public static List<ProductDTO> newListProductDTO(){
        List<ProductDTO> productDTOS = new ArrayList<>();

        ProductDTO product = new ProductDTO();

        product.setBatchNumber(10);
        product.setProductId("Meli002");
        product.setCurrentQuantity(1);
        product.setCurrentTemperature(20.0);
        product.setMinimumTemperature(2.0);
        product.setInitialQuantity(2);
        product.setCurrentTemperature(20);
        product.setManufacturingDate(LocalDateTime.now());
        product.setDueDate(LocalDate.now());
        productDTOS.add(product);

        return productDTOS;
    }
}
