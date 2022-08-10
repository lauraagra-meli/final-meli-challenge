package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.dto.WareHouseCategoryDTO;
import meli.dh.com.finalmeliproject.model.ShippingCategory;
import meli.dh.com.finalmeliproject.model.WareHouse;
import meli.dh.com.finalmeliproject.model.WareHouseCategory;

import java.util.ArrayList;
import java.util.List;

public class GenerateWareHouse {

    public static WareHouse newWareHouse(){

        return WareHouse.builder()
                .id("WH-0001")
                .storageCapacity(300)
                .build();
    }
}
