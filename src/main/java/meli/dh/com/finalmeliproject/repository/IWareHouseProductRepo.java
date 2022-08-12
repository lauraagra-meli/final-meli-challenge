package meli.dh.com.finalmeliproject.repository;

import meli.dh.com.finalmeliproject.model.WareHouseProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IWareHouseProductRepo extends JpaRepository<WareHouseProduct, Long> {

    @Query("select p from WareHouseProduct p where p.product.id = ?1" )
    WareHouseProduct findByProductId(String id);
}
