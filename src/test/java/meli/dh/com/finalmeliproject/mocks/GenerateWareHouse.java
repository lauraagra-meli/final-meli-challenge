package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.dto.WareHouseCategoryDTO;
import meli.dh.com.finalmeliproject.model.ShippingCategory;
import meli.dh.com.finalmeliproject.model.WareHouse;
import meli.dh.com.finalmeliproject.model.WareHouseCategory;

import java.util.ArrayList;
import java.util.List;

public class GenerateWareHouse {

    public static WareHouse newWareHouse(){

        List<WareHouseCategory> wareHouseCategoryList = new ArrayList<>();
        wareHouseCategoryList.add(WareHouseCategory.builder()
                .id(1)
                .capacity(100)
                .storage(0)
                .category(GenerateCategory.newCategoryToSave())
                .wareHouse(WareHouse.builder()
                        .id("WH-0001")
                        .storageCapacity(300)
                        .listOfWareHouseCategory(wareHouseCategoryList)
                        .build())
                .build());

        return WareHouse.builder()
                .id("WH-0001")
                .storageCapacity(300)
                .listOfWareHouseCategory(wareHouseCategoryList)
                .build();
    }
}
