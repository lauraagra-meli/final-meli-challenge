package meli.dh.com.finalmeliproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class WareHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int storageCapacity;
    List<WareHouseCategory> listOfWareHouseCategory;

    @OneToMany(mappedBy = "warehouse")
    private List<WareHouseProduct> listOfWareHouseProduct;
}
