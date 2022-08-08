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
    private String id;

    private int storageCapacity;

    @OneToMany(mappedBy = "wareHouse")
    private List<WareHouseCategory> listOfWareHouseCategory;

}
