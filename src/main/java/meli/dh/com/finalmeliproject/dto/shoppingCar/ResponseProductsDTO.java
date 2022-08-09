package meli.dh.com.finalmeliproject.dto.shoppingCar;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import meli.dh.com.finalmeliproject.model.Product;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class ResponseProductsDTO {
    private List<Product> products;
}
