package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.model.ShoppingCart;

public class GenerateShoppingCart {
    public static ShoppingCart newShoppingCart(){
        return new ShoppingCart(1, GenerateBuyer.newBuyer(), GenerateProductShoppingCart.newProductShoppingCartList());
    }
}
