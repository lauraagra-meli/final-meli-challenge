package meli.dh.com.finalmeliproject.service.inbound;

import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.dto.ResponseDTO;
import meli.dh.com.finalmeliproject.exception.NotFoundExceptionImp;
import meli.dh.com.finalmeliproject.exception.RepresentativeUnauthorizedException;
import meli.dh.com.finalmeliproject.model.Representative;
import meli.dh.com.finalmeliproject.model.WareHouseCategory;
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

    @Override
    public ResponseDTO save(InboundOrderDTO inboundOrderDTO, long representativeId) {
        ResponseDTO response = new ResponseDTO();
        response.setBatchStock(inboundOrderDTO.getBatchStock());

        if (!wareHouseService.wareHouseExist(inboundOrderDTO.getWareHouseCategory().getWareHouseCode())) { //verifica se existe o ware house
            throw new NotFoundExceptionImp("Warehouse not found");
        }

        Representative representative = findRepresentative(representativeId);

        if (!representative.getWareHouse().getId().equals(inboundOrderDTO.getWareHouseCategory().getWareHouseCode())){
            throw new RepresentativeUnauthorizedException("Unauthorized representative");
        }

        WareHouseCategory wareHouseCategory = wareHouseService.findWareHouseCategoryByWareHouseId(inboundOrderDTO.getWareHouseCategory());

        System.out.println(wareHouseCategory);


        return response;
    }


    private Representative findRepresentative(long id){
        return representativeService.findRepresentativeById(id);
    }
}
