package meli.dh.com.finalmeliproject.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WareHouseProductDTO {

    private int totalQuantity;
    private String wareHouseCode;
}
