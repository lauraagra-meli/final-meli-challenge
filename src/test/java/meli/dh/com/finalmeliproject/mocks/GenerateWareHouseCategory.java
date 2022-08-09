package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.model.WareHouseCategory;

import java.util.ArrayList;
import java.util.List;

public class GenerateWareHouseCategory {

    public static WareHouseCategory newWareHouseCategory() {
        return WareHouseCategory.builder()
                .id(1)
                .quantityMax(76)
                .category(GenerateCategory.newCategoryToSave())
                .wareHouse(GenerateWareHouse.newWareHouse())
                .build();
    }

    public static List<WareHouseCategory> newWareHouseCategoryList() {
        List<WareHouseCategory> wareHouseCategories = new ArrayList<>();

        WareHouseCategory wareHouseCategory = new WareHouseCategory();

        wareHouseCategory.setCategory(GenerateCategory.newCategoryToSave());
        wareHouseCategory.setId(2);
        wareHouseCategory.setQuantityMax(100);
        wareHouseCategory.setWareHouse(GenerateWareHouse.newWareHouse());
        wareHouseCategories.add(wareHouseCategory);
        return wareHouseCategories;
    }

}
