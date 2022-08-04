package meli.dh.com.finalmeliproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int shippingCapacity;

    @OneToMany(mappedBy = "shipping")
    private List<ShippingCategory> shippingCategoryList;
}
