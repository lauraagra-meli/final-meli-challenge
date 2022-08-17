package meli.dh.com.finalmeliproject.dto.shoppingCart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPurchaseOrderDto {

    private String productId;
    private int quantity;
}
