package meli.dh.com.finalmeliproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import meli.dh.com.finalmeliproject.model.Product;

import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public class BatchDTO {

    private long id;
    private List<Product> listOfProducts;
}
