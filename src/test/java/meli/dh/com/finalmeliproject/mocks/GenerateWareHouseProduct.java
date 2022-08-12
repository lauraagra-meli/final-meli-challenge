package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.model.WareHouse;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;

import java.util.ArrayList;
import java.util.List;

public class GenerateWareHouseProduct {
    public static WareHouseProduct newWareHouseProduct(){
        return new WareHouseProduct(
                1,
                1,
                new Product(),
                new WareHouse()
        );
    }

    public static List<WareHouseProduct> newWareHouseProductList(){
        List<WareHouseProduct> wList = new ArrayList<>();

        wList.add(newWareHouseProduct());

        WareHouseProduct w2 = newWareHouseProduct();
        w2.setId(2);

        wList.add(w2);

        return wList;
    }
}
