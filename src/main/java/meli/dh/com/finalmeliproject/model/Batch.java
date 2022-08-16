package meli.dh.com.finalmeliproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.time.LocalDate;
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

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dueDate;

    @OneToMany (mappedBy = "batch")
    private List<Product> listOfProducts;
}
