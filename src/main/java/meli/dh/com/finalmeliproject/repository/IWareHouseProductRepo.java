package meli.dh.com.finalmeliproject.repository;

import meli.dh.com.finalmeliproject.dto.WareHouseProductDTO;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IWareHouseProductRepo extends JpaRepository<WareHouseProduct, Long> {
    public List<WareHouseProduct> findAllByProductId(String id);
}
