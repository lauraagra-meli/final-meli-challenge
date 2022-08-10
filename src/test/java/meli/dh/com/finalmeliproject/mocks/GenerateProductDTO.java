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

        product.setProductId("Meli002");
        product.setMaxTemperature(1);
        product.setMinimumTemperature(20.0);
        product.setMinimumTemperature(2.0);
        product.setQuantity(2);
        product.setManufacturingDate(LocalDateTime.now());
        product.setDueDate(LocalDate.now());
        productDTOS.add(product);

        return productDTOS;
    }
}
