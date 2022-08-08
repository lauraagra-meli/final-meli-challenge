package meli.dh.com.finalmeliproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class ProductDTO {
    private String name;
    private int batchNumber;
    private String productId;
    private double maxTemperature;
    private double minimumTemperature;
    private int quantity;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime manufacturingDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dueDate;
}
