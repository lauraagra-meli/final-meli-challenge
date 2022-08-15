package meli.dh.com.finalmeliproject.repository;

import meli.dh.com.finalmeliproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepo extends JpaRepository<Product, Long> {
    public Product findById(String id);

    @Query(value= "SELECT c.category_name AS 'sectionCode', wp.id_warehouse AS 'warehouseCode', p.id AS 'productId', p.id_batch AS 'batchNumber', wp.quantity AS 'currentQuantity', p.due_date AS 'dueDate' " +
            "FROM product p " +
            "INNER JOIN category c ON p.id_category = c.id " +
            "INNER JOIN ware_house_product wp ON p.id = wp.id_product " +
            "WHERE p.id = :productId", nativeQuery = true)
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
