package meli.dh.com.finalmeliproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter @Getter
@Entity
public class PurchaseOrder {
    @Id
    private long id;

    private LocalDateTime dateOrder;

    private String statusOrder;

    @OneToOne
    @JoinColumn(name = "id_shoppingCart")
    private ShoppingCart shoppingCart;
}
