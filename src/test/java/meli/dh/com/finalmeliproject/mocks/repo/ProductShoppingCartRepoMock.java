package meli.dh.com.finalmeliproject.mocks.repo;

import meli.dh.com.finalmeliproject.mocks.GenerateProductShoppingCart;
import meli.dh.com.finalmeliproject.model.ProductShoppingCart;

import java.util.List;

public class ProductShoppingCartRepoMock {
    public static List<ProductShoppingCart> saveAll(){
        return GenerateProductShoppingCart.newProductShoppingCartList();
    }
}
