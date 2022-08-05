package meli.dh.com.finalmeliproject.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private Batch batch;

    private LocalDate dueDate;

    private LocalDateTime manufacturingDate;
}
