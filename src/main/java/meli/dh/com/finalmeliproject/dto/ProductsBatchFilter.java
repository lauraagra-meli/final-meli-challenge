package meli.dh.com.finalmeliproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import meli.dh.com.finalmeliproject.repository.IInboundOrderRepo;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ProductsBatchFilter {
    private long idBatch;
    private String idProduct;
    private String productName;
    private String categoryName;
    private LocalDate dueDate;

    public ProductsBatchFilter(IInboundOrderRepo.IFilterByDueDate dto){
        setIdBatch(dto.getBatchId());
        setIdProduct(dto.getProductId());
        setProductName(dto.getProductName());
        setDueDate(dto.getDueDate());
        setCategoryName(dto.getCategoryName());
    }
}
