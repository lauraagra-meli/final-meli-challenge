package meli.dh.com.finalmeliproject.service.shoppingCart;

import meli.dh.com.finalmeliproject.dto.shoppingCart.PurchaseOrderDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.ResponseShoppingCartDto;

import java.util.List;

public interface IShoppingCartService {
    ResponseShoppingCartDto shoppingCart(PurchaseOrderDto dto);
    List<PurchaseOrderDto> findAllShoppingCartProducts(long orderNumber);
}
