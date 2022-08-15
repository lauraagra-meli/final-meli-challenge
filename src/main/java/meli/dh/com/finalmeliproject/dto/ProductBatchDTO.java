package meli.dh.com.finalmeliproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import meli.dh.com.finalmeliproject.repository.IProductRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductBatchDTO {
    private CategoryDTO category;
    private String productId;
    private List<ProductBatchStockDTO> productsList;

    public ProductBatchDTO(IProductRepo.ISumOfProductStockDTO dto) {
        CategoryDTO categoryDTO = new CategoryDTO();
        List<ProductBatchStockDTO> productBatchStockDTOList = new ArrayList<>();
        this.productId = dto.getProductId();
        categoryDTO.setSectionCode(dto.getSectionCode());
        categoryDTO.setWarehouseCode(dto.getWarehouseCode());
        ProductBatchStockDTO newProductBatch = new ProductBatchStockDTO();
        newProductBatch.setBatchNumber(Integer.parseInt(dto.getBatchNumber()));
        newProductBatch.setCurrentQuantity(Integer.parseInt(dto.getCurrentQuantity()));
        newProductBatch.setDueDate(LocalDate.parse(dto.getDueDate()));

        productBatchStockDTOList.add(newProductBatch);
        this.category = categoryDTO;
        this.productsList = productBatchStockDTOList;

    }
}
