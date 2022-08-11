package meli.dh.com.finalmeliproject.dto.shoppingCart;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PurchaseOrderDto {

    private LocalDate date;
    private String buyerId;
    private String orderStatus;
    private List<ProductPurchaseOrderDto> products;
}
