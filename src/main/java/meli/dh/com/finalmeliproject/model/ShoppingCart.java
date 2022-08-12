package meli.dh.com.finalmeliproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @OneToMany(mappedBy = "shoppingCart")
    private List<ProductShoppingCart> listOfShoppingProducts;

    @OneToOne(mappedBy = "shoppingCart")
    private PurchaseOrder purchaseOrder;
}
