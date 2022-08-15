package meli.dh.com.finalmeliproject.dto;

import lombok.*;
import meli.dh.com.finalmeliproject.repository.IWareHouseProductRepo;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class WareHouseDTO {

    private String productId;
    private List<WareHouseProductDTO> wareHouseProducts;


    public WareHouseDTO(IWareHouseProductRepo.ISumProductStockDTO dto) {
        List<WareHouseProductDTO> wareHouseProductList = new ArrayList<>();
        this.productId = dto.getProductId();
        WareHouseProductDTO wareHouseProduct = new WareHouseProductDTO();
        wareHouseProduct.setTotalQuantity(dto.getTotalQuantity());
        wareHouseProduct.setWareHouseCode(dto.getWareHouseCode());
        wareHouseProductList.add(wareHouseProduct);
        this.wareHouseProducts = wareHouseProductList;

    }


}
