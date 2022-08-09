package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.model.WareHouse;

public class GenerateWareHouse {

    public static WareHouse newWareHouse(){
        return WareHouse.builder()
                .id("meli0989")
                .storageCapacity(2)
                .listOfWareHouseCategory(GenerateWareHouseCategory.newWareHouseCategoryList())
                .build();
    }
}
