package meli.dh.com.finalmeliproject.repository;

import meli.dh.com.finalmeliproject.dto.WareHouseProductDTO;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IWareHouseProductRepo extends JpaRepository<WareHouseProduct, Long> {
//    public List<WareHouseProductDTO> findAllById(String id);
}
