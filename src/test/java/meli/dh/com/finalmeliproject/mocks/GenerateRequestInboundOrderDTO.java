package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.dto.RequestInboundOrderDTO;

public class GenerateRequestInboundOrderDTO {

    public static RequestInboundOrderDTO newRequestInboundOrderToSave() {
        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO();

        return RequestInboundOrderDTO.builder()
                .inboundOrder(inboundOrderDTO)
                .build();
    }
}
