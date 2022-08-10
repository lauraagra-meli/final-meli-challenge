package meli.dh.com.finalmeliproject.dto;

import lombok.*;
import meli.dh.com.finalmeliproject.model.WareHouse;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WareHouseProductDTO {
    private int totalQuantity;
    private WareHouse wareHouse;
}
