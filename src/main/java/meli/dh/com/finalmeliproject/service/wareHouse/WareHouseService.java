package meli.dh.com.finalmeliproject.service.wareHouse;

import meli.dh.com.finalmeliproject.dto.WareHouseCategoryDTO;
import meli.dh.com.finalmeliproject.exception.NotFoundExceptionImp;
import meli.dh.com.finalmeliproject.model.WareHouse;
import meli.dh.com.finalmeliproject.model.WareHouseCategory;
import meli.dh.com.finalmeliproject.repository.IWareHouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WareHouseService implements IWareHouseService {

    @Autowired
    private IWareHouseRepo wareHouseRepo;

    @Override
    public WareHouseCategory findWareHouseCategoryByWareHouseId(WareHouseCategoryDTO wareHouseCategoryDTO) {
        return wareHouseRepo.findById(wareHouseCategoryDTO.getWareHouseCode()).get().getListOfWareHouseCategory().stream()
                .filter(p -> p.getCategory().getCategoryName().equals(wareHouseCategoryDTO.getCategoryName())).findFirst()
                .orElseThrow(() -> new NotFoundExceptionImp("This warehouse does not have this category"));
    }



    public boolean wareHouseExist(String id){
        return wareHouseRepo.findById(id).isPresent();
    }
}
