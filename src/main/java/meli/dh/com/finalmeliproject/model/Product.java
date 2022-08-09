package meli.dh.com.finalmeliproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    @Id
    private String id;

    private String name;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_batch")
    @JsonIgnoreProperties("listOfProducts")
    private Batch batch;

    private LocalDate dueDate;

    private LocalDateTime manufacturingDate;

    public Product(String name, int quantity, Category category, Batch batch, LocalDate dueDate, LocalDateTime manufacturingDate) {
        this.setId("CF-" + UUID.randomUUID());
        this.setName(name);
        this.setQuantity(quantity);
        this.setCategory(category);
        this.setBatch(batch);
        this.setDueDate(dueDate);
        this.setManufacturingDate(manufacturingDate);
    }
}
