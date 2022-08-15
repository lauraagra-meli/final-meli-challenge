package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.dto.shoppingCart.ProductPurchaseOrderDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.PurchaseOrderDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GeneratePurchaseOrderDTO {
    public static PurchaseOrderDto newPurchaseOrder(){
        List<ProductPurchaseOrderDto> list = new ArrayList<>();
        list.add(new ProductPurchaseOrderDto("MELI1203921", 1));
        list.add(new ProductPurchaseOrderDto("MELI1203921", 1));
        return new PurchaseOrderDto(LocalDate.now(), 0, 1, "EM_ABERTO", list);
    }

    public static PurchaseOrderDto newPurchaseOrderExp(){
        List<ProductPurchaseOrderDto> list = new ArrayList<>();
        list.add(new ProductPurchaseOrderDto("MELI1203921", 999));
        list.add(new ProductPurchaseOrderDto("MELI1203921", 999));
        return new PurchaseOrderDto(LocalDate.now(), 0, 1, "EM_ABERTO", list);
    }


    public static PurchaseOrderDto newPurchaseOrderWithShoopingId(){
        List<ProductPurchaseOrderDto> list = new ArrayList<>();
        list.add(new ProductPurchaseOrderDto("MELI1203921", 1));
        list.add(new ProductPurchaseOrderDto("MELI1203921", 1));

        return new PurchaseOrderDto(LocalDate.now(), 1, 1, "EM_ABERTO", list);
    }
}
