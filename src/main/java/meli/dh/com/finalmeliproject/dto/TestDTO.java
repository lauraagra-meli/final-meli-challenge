package meli.dh.com.finalmeliproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import meli.dh.com.finalmeliproject.repository.IProductRepo;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestDTO {

    private String sectionCode;
    private String warehouseCode;
    private String productId;
    private String idBatch;
    private String quantity;
    private String dueDate;

    public TestDTO(IProductRepo.ISumOfProductStockDTO dto) {
        this.sectionCode = dto.getSectionCode();
        this.warehouseCode = dto.getWarehouseCode();
        this.productId = dto.getProductId();
        this.idBatch = dto.getBatchNumber();
        this.quantity = dto.getCurrentQuantity();
        this.dueDate = dto.getDueDate();
    }
}
