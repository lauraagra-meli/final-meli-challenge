package meli.dh.com.finalmeliproject.mocks.repo;

import meli.dh.com.finalmeliproject.mocks.GenerateWareHouse;
import meli.dh.com.finalmeliproject.mocks.GenerateWareHouseCategory;
import meli.dh.com.finalmeliproject.mocks.GenerateWareHouseProduct;
import meli.dh.com.finalmeliproject.model.WareHouse;
import meli.dh.com.finalmeliproject.model.WareHouseCategory;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;

import java.util.List;
import java.util.Optional;

public class WareHouseRepoMock {
    public static Optional<WareHouse> exist(){
        return Optional.of(GenerateWareHouse.newWareHouse());
    }

    public static Optional<WareHouse> notExist(){
        return Optional.empty();
    }

    public static Optional<WareHouse> findByIdException(){
        WareHouse wh = GenerateWareHouse.newWareHouse();
        wh.getListOfWareHouseCategory().get(0).getCategory().setCategoryName("NOT_EXIST");
        return Optional.of(wh);
    }

    public static Optional<WareHouse> findById(){
        return Optional.of(GenerateWareHouse.newWareHouse());
    }

    public static List<WareHouseProduct> saveAll(){
        return GenerateWareHouseProduct.newWareHouseProductList();
    }

    public static WareHouseCategory update(){
        return GenerateWareHouseCategory.newWareHouseCategory();
    }
}
