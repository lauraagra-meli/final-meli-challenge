package meli.dh.com.finalmeliproject.service.batch;

import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.model.Batch;
import meli.dh.com.finalmeliproject.model.Category;
import org.springframework.stereotype.Service;

@Service
public class BatchService implements IBatchService{

    @Override
    public InboundOrderDTO save(InboundOrderDTO inboundOrderDTO, Category category) {

        Batch batch = new Batch();
        return null;
    }
}
