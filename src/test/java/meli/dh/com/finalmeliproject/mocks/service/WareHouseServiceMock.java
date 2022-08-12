package meli.dh.com.finalmeliproject.mocks.service;

import meli.dh.com.finalmeliproject.dto.WareHouseCategoryDTO;
import meli.dh.com.finalmeliproject.mocks.GenerateWareHouseCategory;
import meli.dh.com.finalmeliproject.mocks.GenerateWareHouseProduct;
import meli.dh.com.finalmeliproject.model.WareHouseCategory;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;

import java.util.List;

public class WareHouseServiceMock {
    public static WareHouseCategory findWareHouseCategoryByWareHouseId(){
        return GenerateWareHouseCategory.newWareHouseCategory();
    }

    public static boolean wareHouseExist(String id){
        if(id.equals("NOT_EXIST")) return false;
        return true;
    }

    public static List<WareHouseProduct> saveAll(){
        return GenerateWareHouseProduct.newWareHouseProductList();
    }
    public static WareHouseCategory update(){
        return GenerateWareHouseCategory.newWareHouseCategory();
    }
}
