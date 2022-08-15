package meli.dh.com.finalmeliproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Product {

    @Id
    private String id;

    private String name;

    private double price;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_batch")
    @JsonIgnoreProperties("listOfProducts")
    private Batch batch;

    private LocalDate dueDate;

    private LocalDateTime manufacturingDate;

    public Product(String name, double price, Category category, Batch batch, LocalDate dueDate, LocalDateTime manufacturingDate) {
        this.setId("CF-" + UUID.randomUUID());
        this.setName(name);
        this.setPrice(price);
        this.setCategory(category);
        this.setBatch(batch);
        this.setDueDate(dueDate);
        this.setManufacturingDate(manufacturingDate);
    }

    public int compareToBatch(Product p) {
        return (int) (this.getBatch().getId() - p.getBatch().getId());
    }
}
