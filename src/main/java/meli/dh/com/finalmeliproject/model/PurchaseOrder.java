package meli.dh.com.finalmeliproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter @Getter
@Entity
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dateOrder = LocalDateTime.now();

    private String statusOrder;

    @OneToOne
    @JoinColumn(name = "id_shoppingCart")
    private ShoppingCart shoppingCart;
}
