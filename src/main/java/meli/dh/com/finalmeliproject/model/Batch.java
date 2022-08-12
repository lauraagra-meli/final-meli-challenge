package meli.dh.com.finalmeliproject.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Batch {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @OneToMany (mappedBy = "batch")
    private List<Product> listOfProducts;
}
