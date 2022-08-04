package meli.dh.com.finalmeliproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    List<WareHouseProduct> listOfWareHouseProduct;
}
