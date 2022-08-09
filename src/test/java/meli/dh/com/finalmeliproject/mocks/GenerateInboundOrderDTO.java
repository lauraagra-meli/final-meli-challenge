package meli.dh.com.finalmeliproject.mocks;

import lombok.Getter;
import lombok.Setter;
import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;

import java.time.LocalDateTime;

@Getter
@Setter
public class GenerateInboundOrderDTO {

    public static InboundOrderDTO newInboundOrderDTO() {

        return InboundOrderDTO.builder()
                .orderDate(LocalDateTime.now())
                .wareHouseCategory(GenerateWareHouseCategoryDTO.newWareHouseCategoryDTO())
                .batchStock(GenerateProductDTO.newListProductDTO())
                .build();


    }
}
