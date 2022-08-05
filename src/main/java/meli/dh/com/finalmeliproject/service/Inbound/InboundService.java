package meli.dh.com.finalmeliproject.service.Inbound;

import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.dto.ResponseDTO;
import meli.dh.com.finalmeliproject.repository.IWareHouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InboundService implements IInboundService {

    @Autowired
    private IWareHouseRepo wareHouseRepo;

    @Override
    public ResponseDTO save(InboundOrderDTO inboundOrderDTO) {
        ResponseDTO response = new ResponseDTO();
        response.setBatchStock(inboundOrderDTO.getBatchStock());

        if (!this.wareHouseExist(inboundOrderDTO.getWareHouseCategory().getWareHouseCode())) { //verifica se existe o ware house
            //throw new NotFoundExceptionImp();
        }

        return response;
    }

    private boolean wareHouseExist(String id){
        return wareHouseRepo.findById(id).isPresent();
    }
}
