package meli.dh.com.finalmeliproject.mocks;

import lombok.Getter;
import lombok.Setter;
import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.dto.ProductDTO;
import meli.dh.com.finalmeliproject.dto.WareHouseCategoryDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GenerateInboundOrderDTO {

    private List<ProductDTO> batchStock;

    public static InboundOrderDTO newInboundOrderDTO() {
        WareHouseCategoryDTO wareHouseCategoryDTO = new WareHouseCategoryDTO(
                "CONGELADO",
                "WH-0001"
        );

        List<ProductDTO> batchStock = new ArrayList<>();
        batchStock.add(
                GenerateProductDTO.newProductDTOCongelado()
        );
        batchStock.add(
                GenerateProductDTO.newProductDTOCongelado()
        );

        return InboundOrderDTO.builder()
                .orderDate(LocalDateTime.now())
                .wareHouseCategory(wareHouseCategoryDTO)
                .batchStock(batchStock)
                .build();
    }
}
