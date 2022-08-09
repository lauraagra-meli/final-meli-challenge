package meli.dh.com.finalmeliproject.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WareHouse {
    @Id
    private String id;

    private int storageCapacity;

    @OneToMany(mappedBy = "wareHouse")
    private List<WareHouseCategory> listOfWareHouseCategory;

    @OneToMany(mappedBy = "wareHouse")
    private List<WareHouseProduct> listOfWareHouseProduct;

    @OneToMany(mappedBy = "wareHouse")
    private List<InboundOrder> listOfInboundOrders;
}
