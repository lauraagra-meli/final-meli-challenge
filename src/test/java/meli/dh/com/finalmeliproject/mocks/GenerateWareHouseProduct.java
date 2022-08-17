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
                2,
                GenerateProduct.newProductToSave(),
                GenerateWareHouse.newWareHouse()
        );
    }

    public static WareHouseProduct newWareHouseProductManyQuantity(){
        return new WareHouseProduct(
                1,
                0,
                GenerateProduct.newProductToSave(),
                GenerateWareHouse.newWareHouse()
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
