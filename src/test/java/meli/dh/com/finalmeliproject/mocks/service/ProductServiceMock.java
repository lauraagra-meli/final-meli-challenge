package meli.dh.com.finalmeliproject.mocks.service;

import meli.dh.com.finalmeliproject.mocks.GenerateProduct;
import meli.dh.com.finalmeliproject.mocks.GenerateWareHouseProduct;
import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;

public class ProductServiceMock {
    public static WareHouseProduct findProductById(){
        return GenerateWareHouseProduct.newWareHouseProduct();
    }

    public static WareHouseProduct findProductByIdQuantityInsufficient(){
        return GenerateWareHouseProduct.newWareHouseProductManyQuantity();
    }

    public static Product save(){
        return GenerateProduct.newProductToSave();
    }
}
