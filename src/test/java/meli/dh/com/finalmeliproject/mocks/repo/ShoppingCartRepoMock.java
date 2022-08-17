package meli.dh.com.finalmeliproject.mocks.repo;

import meli.dh.com.finalmeliproject.mocks.GenerateShoppingCart;
import meli.dh.com.finalmeliproject.mocks.GenerateWareHouse;
import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.model.ShoppingCart;
import meli.dh.com.finalmeliproject.model.WareHouse;

import java.util.Optional;

public class ShoppingCartRepoMock {
    public static Optional<ShoppingCart> findById(){
        return Optional.of(GenerateShoppingCart.newShoppingCart());
    }

    public static Optional<ShoppingCart> findByIdException(){
        return Optional.empty();
    }

    public static ShoppingCart save(){
        return GenerateShoppingCart.newShoppingCart();
    }
}
