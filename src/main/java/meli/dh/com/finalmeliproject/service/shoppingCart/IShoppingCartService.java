package meli.dh.com.finalmeliproject.service.shoppingCart;

import meli.dh.com.finalmeliproject.dto.shoppingCart.PurchaseOrderDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.ResponseShoppingCartDto;
import meli.dh.com.finalmeliproject.model.ProductShoppingCart;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;

import java.util.List;

public interface IShoppingCartService {

    ResponseShoppingCartDto shoppingCart(PurchaseOrderDto dto);
    List<ProductShoppingCart> findAllShoppingCartProducts(long id);
}
