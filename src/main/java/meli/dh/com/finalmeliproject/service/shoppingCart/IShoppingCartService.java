package meli.dh.com.finalmeliproject.service.shoppingCart;

import meli.dh.com.finalmeliproject.dto.shoppingCart.PurchaseOrderDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.ResponseShoppingCartDto;
import meli.dh.com.finalmeliproject.model.PurchaseOrder;
import meli.dh.com.finalmeliproject.model.ShoppingCart;

import java.util.Optional;

public interface IShoppingCartService {

    ResponseShoppingCartDto shoppingCart(PurchaseOrderDto dto);
    ShoppingCart findShoppingCartProductsById(long id);
    PurchaseOrder editShoppingCart(long id);
}
