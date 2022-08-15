package meli.dh.com.finalmeliproject.mocks.repo;

import meli.dh.com.finalmeliproject.mocks.GeneratePurchaseOrder;
import meli.dh.com.finalmeliproject.mocks.GenerateShoppingCart;
import meli.dh.com.finalmeliproject.model.PurchaseOrder;
import meli.dh.com.finalmeliproject.model.ShoppingCart;

import java.util.Optional;

public class PurchaseOrderRepoMock {
    public static Optional<PurchaseOrder> save(){
        return Optional.of(GeneratePurchaseOrder.newPurchaseOrder());
    }
}
