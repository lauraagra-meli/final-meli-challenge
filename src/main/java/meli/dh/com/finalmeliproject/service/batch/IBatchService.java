package meli.dh.com.finalmeliproject.service.batch;

import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.dto.ResponseDTO;
import meli.dh.com.finalmeliproject.model.Product;

public interface IBatchService {
    InboundOrderDTO save(InboundOrderDTO inboundOrderDTO);
}
