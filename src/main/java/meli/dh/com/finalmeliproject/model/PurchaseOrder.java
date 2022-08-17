package meli.dh.com.finalmeliproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import meli.dh.com.finalmeliproject.model.enums.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter @Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dateOrder = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private OrderStatus statusOrder;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_shoppingCart")
    private ShoppingCart shoppingCart;
}
