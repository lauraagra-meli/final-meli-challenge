package meli.dh.com.finalmeliproject.service.shoppingCart;

import meli.dh.com.finalmeliproject.dto.shoppingCart.PurchaseOrderDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.ResponseShoppingCartDto;

public interface IShoppingCartService {

    ResponseShoppingCartDto shoppingCart(PurchaseOrderDto dto);
}
