package meli.dh.com.finalmeliproject.repository;

import meli.dh.com.finalmeliproject.dto.WareHouseProductDTO;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IWareHouseProductRepo extends JpaRepository<WareHouseProduct, Long> {
    @Query(value =
            "select new meli.dh.com.finalmeliproject.dto.WareHouseProductDTO(w.id, sum(b.currentQuantity)) " +
                    "from WareHouse w inner join Category c on w.id = c.warehouse.id " +
                    "inner join InboundOrder i on c.id = i.category.id " +
                    "inner join Batch b on i.id = b.inboundOrder.id " +
                    "inner join Product p on p.id = b.listOfProduct where p.id = :productsId " +
                    "group by w")
    public List<WareHouseProductDTO> findAllById(String id);
}
