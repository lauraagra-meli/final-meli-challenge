package meli.dh.com.finalmeliproject.service.wareHouseProductService;

import meli.dh.com.finalmeliproject.dto.BatchDTO;
import meli.dh.com.finalmeliproject.model.Batch;
import meli.dh.com.finalmeliproject.repository.IBatchRepo;
import meli.dh.com.finalmeliproject.repository.IWareHouseProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WareHouseProductService implements IWareHouseProductService {

    @Autowired
    private IBatchRepo batchRepo;

    @Override
    public List<BatchDTO> allProducts(String id) {
        List<BatchDTO> allProducts = batchRepo.findById(id);
        return allProducts;
    }
}
