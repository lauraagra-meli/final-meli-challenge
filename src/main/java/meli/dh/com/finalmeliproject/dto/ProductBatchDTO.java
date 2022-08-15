package meli.dh.com.finalmeliproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductBatchDTO {
    private CategoryDTO category;
    private String productId;
    private List<ProductBatchStockDTO> productsList;
}
