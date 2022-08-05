package meli.dh.com.finalmeliproject.service.Inbound;

import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.dto.ResponseDTO;
import meli.dh.com.finalmeliproject.exception.NotFoundExceptionImp;
import meli.dh.com.finalmeliproject.exception.RepresentativeUnauthorizedException;
import meli.dh.com.finalmeliproject.model.Representative;
import meli.dh.com.finalmeliproject.repository.IRepresentativeRepo;
import meli.dh.com.finalmeliproject.repository.IWareHouseRepo;
import meli.dh.com.finalmeliproject.service.Representative.IRepresentativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InboundService implements IInboundService {

    @Autowired
    private IWareHouseRepo wareHouseRepo;

    @Autowired
    private IRepresentativeService representativeService;

    @Override
    public ResponseDTO save(InboundOrderDTO inboundOrderDTO, long representativeId) {
        ResponseDTO response = new ResponseDTO();
        response.setBatchStock(inboundOrderDTO.getBatchStock());

        if (!this.wareHouseExist(inboundOrderDTO.getWareHouseCategory().getWareHouseCode())) { //verifica se existe o ware house
            throw new NotFoundExceptionImp("Warehouse not found");
        }

        Representative representative = findRepresentative(representativeId);


        if (representative.getWareHouse().getId() != inboundOrderDTO.getWareHouseCategory().getWareHouseCode()){
            throw new RepresentativeUnauthorizedException("Unauthorized representative");
        }

        return response;
    }

    private boolean wareHouseExist(String id){
        return wareHouseRepo.findById(id).isPresent();
    }

    private Representative findRepresentative(long id){
        return representativeService.findRepresentativeById(id);
    }
}
