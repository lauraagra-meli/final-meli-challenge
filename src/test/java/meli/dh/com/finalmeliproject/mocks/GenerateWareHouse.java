package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.dto.WareHouseCategoryDTO;
import meli.dh.com.finalmeliproject.model.ShippingCategory;
import meli.dh.com.finalmeliproject.model.WareHouse;
import meli.dh.com.finalmeliproject.model.WareHouseCategory;

import java.util.ArrayList;
import java.util.List;

public class GenerateWareHouse {

    public static WareHouse newWareHouse(){

        List<WareHouseCategory> wareHouseCategory = new ArrayList<>();
        wareHouseCategory.add(new WareHouseCategory(3, 200, 0, null, null));

        return WareHouse.builder()
                .id("meli0989")
                .storageCapacity(2)
                .listOfWareHouseCategory(wareHouseCategory)
                .build();
    }
}
