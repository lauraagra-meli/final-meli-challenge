package meli.dh.com.finalmeliproject.service.Inbound;

import meli.dh.com.finalmeliproject.dto.BatchDTO;
import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.model.Batch;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InboundService implements IInboundService {
    @Override
    public List<BatchDTO> save(InboundOrderDTO inboundOrderDTO) {
        List<Batch> batches;

        return InboundOrderDTO.findBatchStock(inboundOrderDTO.getBatchStock());
    }
}
