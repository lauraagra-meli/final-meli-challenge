package meli.dh.com.finalmeliproject.service.wareHouse;

import meli.dh.com.finalmeliproject.dto.WareHouseCategoryDTO;
import meli.dh.com.finalmeliproject.model.WareHouse;
import meli.dh.com.finalmeliproject.model.WareHouseCategory;

public interface IWareHouseService {
    WareHouseCategory findWareHouseCategoryByWareHouseId(WareHouseCategoryDTO wareHouseCategoryDTO);
    boolean wareHouseExist(String id);
}
