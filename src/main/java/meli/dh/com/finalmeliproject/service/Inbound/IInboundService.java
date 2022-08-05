package meli.dh.com.finalmeliproject.service.Inbound;

import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.dto.ResponseDTO;


public interface IInboundService {
    ResponseDTO save(InboundOrderDTO inboundOrderDTO, long representativeId);
}
