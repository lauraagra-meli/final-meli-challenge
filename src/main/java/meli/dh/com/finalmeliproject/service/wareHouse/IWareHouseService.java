package meli.dh.com.finalmeliproject.service.wareHouse;

import meli.dh.com.finalmeliproject.dto.WareHouseCategoryDTO;
import meli.dh.com.finalmeliproject.dto.WareHouseDTO;
import meli.dh.com.finalmeliproject.model.WareHouseCategory;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;

import java.util.List;

public interface IWareHouseService {
    WareHouseCategory findWareHouseCategoryByWareHouseId(WareHouseCategoryDTO wareHouseCategoryDTO);
    boolean wareHouseExist(String id);
    List<WareHouseProduct> saveAll(List<WareHouseProduct> wareHouseProducts);
    WareHouseCategory update(WareHouseCategory wareHouseCategory);
    List<WareHouseDTO> findAllProductsByWareHouse(String id);
    WareHouseCategory findByWareHouseIdAndCategoryName(String wareHouseId, long categoryId);
}
