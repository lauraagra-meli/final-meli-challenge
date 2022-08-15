package meli.dh.com.finalmeliproject.repository;


import meli.dh.com.finalmeliproject.model.WareHouseProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface IWareHouseProductRepo extends JpaRepository<WareHouseProduct, Long> {

    @Query("select p from WareHouseProduct p where p.product.id = ?1")
    WareHouseProduct findByProductId(String id);

    @Query(value= "select DISTINCT p.name AS 'productId', wp.id_warehouse as 'wareHouseCode', wp.quantity as 'totalQuantity'" +
            "from ware_house_product wp " +
            "INNER JOIN product p on wp.id_product = p.name " +
            "where p.name LIKE :productId", nativeQuery = true)
    List<ISumProductStockDTO> findAllProductsByWareHouse(@Param("productId") String productId);
    interface ISumProductStockDTO {

        String getProductId();
        String getWareHouseCode();
        int getTotalQuantity();



    }
}
