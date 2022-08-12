package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.dto.ProductDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GenerateProductDTO {

    public static ProductDTO newProductDTOCongelado(){
        ProductDTO dto = new ProductDTO();
        dto.setName("TEST");
        dto.setMaxTemperature(0);
        dto.setQuantity(2);
        dto.setMinimumTemperature(-90);
        return dto;
    }
}
