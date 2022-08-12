package meli.dh.com.finalmeliproject.dto.shoppingCart;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PurchaseOrderDto {

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private long shoopingCartId;
    private long buyerId;
    private String orderStatus;
    private List<ProductPurchaseOrderDto> products;
}
