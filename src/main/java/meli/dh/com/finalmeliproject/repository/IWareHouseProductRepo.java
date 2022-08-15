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

    @Query(value= "select p.id AS 'productId', wp.quantity AS 'totalQuantity', wp.id_warehouse AS 'wareHouseCode'" +
            "from ware_house_product wp INNER JOIN product p where wp.id_product = p.id and p.name LIKE :productId"
            , nativeQuery = true)
    List<ISumProductStockDTO> findAllProductsByWareHouse(@Param("productId") String productId);
    interface ISumProductStockDTO {

        String getProductId();
        String getWareHouseCode();
        int getTotalQuantity();
    }
}
