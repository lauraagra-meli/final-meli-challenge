package meli.dh.com.finalmeliproject.service.wareHouse;

import meli.dh.com.finalmeliproject.dto.WareHouseCategoryDTO;
import meli.dh.com.finalmeliproject.dto.WareHouseDTO;
import meli.dh.com.finalmeliproject.exception.NotFoundExceptionImp;
import meli.dh.com.finalmeliproject.model.WareHouseCategory;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;
import meli.dh.com.finalmeliproject.repository.IWareHouseCategoryRepo;
import meli.dh.com.finalmeliproject.repository.IWareHouseProductRepo;
import meli.dh.com.finalmeliproject.repository.IWareHouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WareHouseService implements IWareHouseService {

    @Autowired
    private IWareHouseRepo wareHouseRepo;

    @Autowired
    private IWareHouseProductRepo wareHouseProductRepo;

    @Autowired
    private IWareHouseCategoryRepo wareHouseCategoryRepo;

    @Override
    public WareHouseCategory findWareHouseCategoryByWareHouseId(WareHouseCategoryDTO wareHouseCategoryDTO) {
        return wareHouseRepo.findById(wareHouseCategoryDTO.getWareHouseCode()).get().getListOfWareHouseCategory().stream()
                .filter(p -> p.getCategory().getCategoryName().equals(wareHouseCategoryDTO.getCategoryName())).findFirst()
                .orElseThrow(() -> new NotFoundExceptionImp("This warehouse does not have this category"));
    }

    @Override
    public List<WareHouseDTO> findAllProductsByWareHouse(String id) {
        List<WareHouseDTO> wareHouseProductList = wareHouseProductRepo.findAllProductsByWareHouse(id)
                .stream().map(WareHouseDTO::new)
                .collect(Collectors.toList());

        if (wareHouseProductList.isEmpty()) {
            throw new NotFoundExceptionImp("Product not found any warehouse");
        }

        return wareHouseProductList;
    }

    @Override
    public List<WareHouseProduct> saveAll(List<WareHouseProduct> wareHouseProducts) {
        return wareHouseProductRepo.saveAll(wareHouseProducts);
    }

    @Override
    public WareHouseCategory update(WareHouseCategory wareHouseCategory) {
        return wareHouseCategoryRepo.save(wareHouseCategory);
    }

    @Override
    public boolean wareHouseExist(String id) {
        return wareHouseRepo.findById(id).isPresent();
    }

    @Override
    public WareHouseCategory findByWareHouseIdAndCategoryName(String wareHouseId, long categoryId){
        return wareHouseCategoryRepo.findByWareHouseIdAndCategoryId(wareHouseId, categoryId);
    }
}
