package meli.dh.com.finalmeliproject.service.inbound;

import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.dto.ProductDTO;
import meli.dh.com.finalmeliproject.dto.ResponseDTO;
import meli.dh.com.finalmeliproject.exception.BadRequestExceptionImp;
import meli.dh.com.finalmeliproject.exception.NotFoundExceptionImp;
import meli.dh.com.finalmeliproject.exception.RepresentativeUnauthorizedException;
import meli.dh.com.finalmeliproject.model.Representative;
import meli.dh.com.finalmeliproject.model.WareHouse;
import meli.dh.com.finalmeliproject.model.WareHouseCategory;
import meli.dh.com.finalmeliproject.service.batch.IBatchService;
import meli.dh.com.finalmeliproject.service.representative.IRepresentativeService;
import meli.dh.com.finalmeliproject.service.wareHouse.IWareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InboundService implements IInboundService {

    @Autowired
    private IWareHouseService wareHouseService;

    @Autowired
    private IRepresentativeService representativeService;

    @Autowired
    private IBatchService batchService;

    @Override
    public ResponseDTO save(InboundOrderDTO inboundOrderDTO, long representativeId) {
        ResponseDTO response = new ResponseDTO();

        if (!wareHouseService.wareHouseExist(inboundOrderDTO.getWareHouseCategory().getWareHouseCode())) { //verifica se existe o ware house
            throw new NotFoundExceptionImp("Warehouse not found");
        }

        Representative representative = findRepresentative(representativeId);

        if (!representative.getWareHouse().getId().equals(inboundOrderDTO.getWareHouseCategory().getWareHouseCode())){
            throw new RepresentativeUnauthorizedException("Unauthorized representative");
        }

        WareHouseCategory wareHouseCategory = wareHouseService.findWareHouseCategoryByWareHouseId(inboundOrderDTO.getWareHouseCategory());

        InboundOrderDTO inboundSaved = batchService.save(inboundOrderDTO, wareHouseCategory);
        response.setBatchStock(inboundSaved.getBatchStock());
        response.setBatchId(inboundSaved.getBatchId());

        return response;
    }


    private Representative findRepresentative(long id){
        return representativeService.findRepresentativeById(id);
    }
}
