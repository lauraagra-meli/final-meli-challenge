package meli.dh.com.finalmeliproject.repository;

import meli.dh.com.finalmeliproject.model.WareHouseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IWareHouseCategoryRepo extends JpaRepository<WareHouseCategory, Long> {
    @Query(value = "SELECT whp " +
            "from WareHouseCategory whp " +
            "where whp.wareHouse.id = :wareHouseId and whp.category.id = :categoryId")
    WareHouseCategory findByWareHouseIdAndCategoryId(String wareHouseId, long categoryId);
}
