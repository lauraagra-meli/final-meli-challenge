package meli.dh.com.finalmeliproject.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int shippingCapacity;

    @OneToMany(mappedBy = "shipping")
    private List<ShippingCategory> shippingCategoryList;
}
