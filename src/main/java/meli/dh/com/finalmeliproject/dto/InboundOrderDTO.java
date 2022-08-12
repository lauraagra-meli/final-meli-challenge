package meli.dh.com.finalmeliproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import meli.dh.com.finalmeliproject.model.Product;

import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class InboundOrderDTO {
    private long orderNumber;

    private long batchId;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime orderDate;

    private WareHouseCategoryDTO wareHouseCategory;

    private List<ProductDTO> batchStock;

}
