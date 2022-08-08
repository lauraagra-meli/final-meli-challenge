package meli.dh.com.finalmeliproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class WareHouseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int capacity;//capacidade maxima
    private int storage;//estoque atual

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_warehouse")
    private WareHouse wareHouse;

    public boolean doesItFit(int receivingQuantity){
        return this.getCapacity()-this.getStorage() >= receivingQuantity;
    }
}
