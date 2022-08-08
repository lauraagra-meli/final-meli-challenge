package meli.dh.com.finalmeliproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class WareHouseProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_warehouse")
    private WareHouse wareHouse;

    public WareHouseProduct(int quantity, Product product, WareHouse wareHouse) {
        this.setQuantity(quantity);
        this.setProduct(product);
        this.setWareHouse(wareHouse);
    }
}
