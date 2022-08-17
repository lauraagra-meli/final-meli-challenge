package meli.dh.com.finalmeliproject.repository;

import meli.dh.com.finalmeliproject.dto.BatchDTO;
import meli.dh.com.finalmeliproject.dto.ProductBatchStockDTO;
import meli.dh.com.finalmeliproject.dto.ProductDTO;
import meli.dh.com.finalmeliproject.model.Batch;
import meli.dh.com.finalmeliproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepo extends JpaRepository<Product, Long> {
    public Product findById(String id);

    @Query(value= "SELECT DISTINCT p.name AS 'productId', wp.quantity AS 'currentQuantity', p.due_date AS 'dueDate', id_warehouse " +
            "AS 'warehouseCode', id_batch as 'batchNumber', category_name AS 'sectionCode'" +
            "FROM ware_house_product wp " +
            "INNER JOIN product p on wp.id_product = p.id " +
            "INNER JOIN category c on c.id = p.id_category " +
            "WHERE p.name LIKE :productId", nativeQuery = true)
    public List<ISumOfProductStockDTO> allProductsPerBatch (@Param("productId") String productId);

    public static interface ISumOfProductStockDTO {
        String getSectionCode();
        String getWarehouseCode();
        String getProductId();
        String getBatchNumber();
        String getCurrentQuantity();
        String getDueDate();
    }
}
