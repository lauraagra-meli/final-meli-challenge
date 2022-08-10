package meli.dh.com.finalmeliproject.service.shoppingCart;

import meli.dh.com.finalmeliproject.model.ShoppingCart;
import meli.dh.com.finalmeliproject.model.PurchaseOrder;



public interface IShoppingCartService {

    PurchaseOrder purchaseOrder (ShoppingCart cart, long buyerId );



}
