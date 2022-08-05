package meli.dh.com.finalmeliproject.service.Inbound;

import meli.dh.com.finalmeliproject.dto.BatchDTO;
import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;

import java.util.List;


public interface IInboundService {
    List<BatchDTO> save(InboundOrderDTO inboundOrderDTO);
}
