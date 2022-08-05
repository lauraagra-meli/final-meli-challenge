package meli.dh.com.finalmeliproject.service.Inbound;

import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.dto.ResponseDTO;
import org.springframework.stereotype.Service;


@Service
public class InboundService implements IInboundService {
    @Override
    public ResponseDTO save(InboundOrderDTO inboundOrderDTO) {
        ResponseDTO response = new ResponseDTO();
        response.setBatchStock(inboundOrderDTO.getBatchStock());

        //vamos programar aqui

        return response;
    }
}
