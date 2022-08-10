package meli.dh.com.finalmeliproject.repository;

import meli.dh.com.finalmeliproject.model.WareHouseProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWareHouseProductRepo extends JpaRepository<WareHouseProduct, Long> {
}
