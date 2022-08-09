package meli.dh.com.finalmeliproject.service.inbound;

import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.dto.ResponseDTO;


public interface IInboundService {
    ResponseDTO save(InboundOrderDTO inboundOrderDTO, long representativeId);
    ResponseDTO update(InboundOrderDTO inboundOrderDTO, long representativeId);
}
