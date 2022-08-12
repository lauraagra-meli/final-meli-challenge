package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.model.WareHouseCategory;

import java.util.ArrayList;
import java.util.List;

public class GenerateWareHouseCategory {

    public static WareHouseCategory newWareHouseCategory() {
        return WareHouseCategory.builder()
                .id(1)
                .capacity(100)
                .storage(0)
                .category(GenerateCategory.newCategoryToSave())
                .wareHouse(GenerateWareHouse.newWareHouse())
                .build();
    }

}
