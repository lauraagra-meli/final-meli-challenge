package meli.dh.com.finalmeliproject.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    public void sumStorage(int productQuantity){
        this.storage += productQuantity;
    }

    public void subStorage(int productQuantity){
        this.storage -= productQuantity;
        if (storage < 0) {
            storage = 0;
        }
    }
}
