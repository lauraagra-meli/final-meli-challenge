package meli.dh.com.finalmeliproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class BatchDTO {
    private int batchNumber;
    private String productId;
    private double currentTemperature;
    private double minimumTemperature;
    private int initialQuantity;
    private int currentQuantity;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime manufacturingDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dueDate;
}