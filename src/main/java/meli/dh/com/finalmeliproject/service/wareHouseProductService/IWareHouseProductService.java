package meli.dh.com.finalmeliproject.service.wareHouseProductService;

import meli.dh.com.finalmeliproject.dto.BatchDTO;
import meli.dh.com.finalmeliproject.model.Batch;

import java.util.List;
import java.util.Optional;

public interface IWareHouseProductService {

    List<BatchDTO> allProducts (String id);
}
