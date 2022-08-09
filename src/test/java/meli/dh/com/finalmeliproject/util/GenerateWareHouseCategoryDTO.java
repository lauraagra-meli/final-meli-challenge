package meli.dh.com.finalmeliproject.util;

import meli.dh.com.finalmeliproject.dto.WareHouseCategoryDTO;

public class GenerateWareHouseCategoryDTO {

    public static WareHouseCategoryDTO newWareHouseCategoryDTO(){

       return WareHouseCategoryDTO.builder()
                .categoryName("fresco")
                .wareHouseCode("1234")
                .build();

    }
}
