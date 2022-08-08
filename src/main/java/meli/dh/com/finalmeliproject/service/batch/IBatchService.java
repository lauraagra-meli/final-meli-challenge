package meli.dh.com.finalmeliproject.service.batch;

import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.dto.ResponseDTO;
import meli.dh.com.finalmeliproject.model.Category;
import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.model.WareHouseCategory;

public interface IBatchService {
    InboundOrderDTO save(InboundOrderDTO inboundOrderDTO, WareHouseCategory wareHouseCategory);
}
