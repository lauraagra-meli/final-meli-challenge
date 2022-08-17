package meli.dh.com.finalmeliproject.mocks;

import lombok.Getter;
import lombok.Setter;
import meli.dh.com.finalmeliproject.dto.ResponseDTO;
import meli.dh.com.finalmeliproject.model.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
public class GenerateResponseDTO {

    public static ResponseDTO newResponseDTO() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("MELI02193", "TEST", 12, null, null, LocalDate.of(2023, 02, 15), LocalDateTime.now()));

        return ResponseDTO.builder()
                .batchId(1)
                .batchStock(productList)
                .build();
    }

  }
