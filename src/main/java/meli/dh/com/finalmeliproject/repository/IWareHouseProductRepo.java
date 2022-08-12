package meli.dh.com.finalmeliproject.repository;

import meli.dh.com.finalmeliproject.model.WareHouseProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWareHouseProductRepo extends JpaRepository<WareHouseProduct, Long> {
}
