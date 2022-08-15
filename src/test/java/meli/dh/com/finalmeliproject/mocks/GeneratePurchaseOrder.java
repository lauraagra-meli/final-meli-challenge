package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.model.PurchaseOrder;
import meli.dh.com.finalmeliproject.model.ShoppingCart;
import meli.dh.com.finalmeliproject.model.enums.OrderStatus;

import java.time.LocalDateTime;

public class GeneratePurchaseOrder {
    public static PurchaseOrder newPurchaseOrder(){
        return new PurchaseOrder(
                1,
                LocalDateTime.now(),
                OrderStatus.OPENED,
                GenerateShoppingCart.newShoppingCart()
        );
    }

    public static PurchaseOrder newPurchaseOrderClose(){
        return new PurchaseOrder(
                1,
                LocalDateTime.now(),
                OrderStatus.CLOSED,
                GenerateShoppingCart.newShoppingCart()
        );
    }


}
