package meli.dh.com.finalmeliproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter @Setter
public class ShippingCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int quantityMax;

    @JoinColumn
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
}
