package meli.dh.com.finalmeliproject.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "id_buyer")
    private Buyer buyer;

    private String OrderStatus;

    @OneToMany(mappedBy = "purchaseOrder")
    private List<ShoppingCart> shoppingCart;

    private double totalPrice;



}
