package meli.dh.com.finalmeliproject.dto;

import lombok.*;
import meli.dh.com.finalmeliproject.model.Product;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDTO {
    private long batchId;
    private List<Product> batchStock;
}
