package meli.dh.com.finalmeliproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class InboundOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderNumber;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime orderDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_warehouse")
    private WareHouse wareHouse;

    @ManyToOne
    @JoinColumn(name = "id_batch")
    private Batch batch;

    public InboundOrder(Category category, WareHouse wareHouse, Batch batch){
        this.setCategory(category);
        this.setWareHouse(wareHouse);
        this.setBatch(batch);
    }
}
