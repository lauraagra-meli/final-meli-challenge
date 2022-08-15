package meli.dh.com.finalmeliproject.mocks.repo;

import meli.dh.com.finalmeliproject.mocks.GeneratePurchaseOrder;
import meli.dh.com.finalmeliproject.model.PurchaseOrder;

import java.util.Optional;

public class PurchaseOrderRepoMock {
    public static PurchaseOrder save(){
        return GeneratePurchaseOrder.newPurchaseOrder();
    }

    public static Optional<PurchaseOrder> findById() {
        return Optional.of(GeneratePurchaseOrder.newPurchaseOrder());
    }

    public static Optional<PurchaseOrder> findByIdExceptionNotExist() {
        return Optional.empty();
    }

    public static Optional<PurchaseOrder> findByIdExceptionIsClose() {
        return Optional.of(GeneratePurchaseOrder.newPurchaseOrderClose());
    }


}
