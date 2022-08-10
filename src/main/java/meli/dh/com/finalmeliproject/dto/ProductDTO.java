package meli.dh.com.finalmeliproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import meli.dh.com.finalmeliproject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String name;
    private String productId;
    private double maxTemperature;
    private double minimumTemperature;
    private int quantity;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime manufacturingDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dueDate;

    public ProductDTO(Product p) {
        this.productId = getProductId();
        this.name = getName();
        this.quantity = getQuantity();
    }
}
