package meli.dh.com.finalmeliproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
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
