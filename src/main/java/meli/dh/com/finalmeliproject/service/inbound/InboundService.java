package meli.dh.com.finalmeliproject.service.inbound;

import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.dto.ProductDTO;
import meli.dh.com.finalmeliproject.dto.ResponseDTO;
import meli.dh.com.finalmeliproject.exception.BadRequestExceptionImp;
import meli.dh.com.finalmeliproject.exception.NotFoundExceptionImp;
import meli.dh.com.finalmeliproject.exception.RepresentativeUnauthorizedException;
import meli.dh.com.finalmeliproject.model.*;
import meli.dh.com.finalmeliproject.repository.IInboundOrderRepo;
import meli.dh.com.finalmeliproject.service.batch.IBatchService;
import meli.dh.com.finalmeliproject.service.representative.IRepresentativeService;
import meli.dh.com.finalmeliproject.service.wareHouse.IWareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class InboundService implements IInboundService {

    @Autowired
    private IInboundOrderRepo inboundOrderRepo;

    @Autowired
    private IWareHouseService wareHouseService;

    @Autowired
    private IRepresentativeService representativeService;

    @Autowired
    private IBatchService batchService;

    @Override
    public ResponseDTO save(InboundOrderDTO inboundOrderDTO, long representativeId) {
        ResponseDTO response = new ResponseDTO();
        Batch batch;
        validations(
                inboundOrderDTO.getWareHouseCategory().getWareHouseCode(), //id do armazem
                representativeId, //id do representante
                inboundOrderDTO.getWareHouseCategory().getWareHouseCode() //nome da categoria
        );

        WareHouseCategory wareHouseCategory = wareHouseService.
                findWareHouseCategoryByWareHouseId(
                        inboundOrderDTO.getWareHouseCategory()
                );

        batch = batchService.save(inboundOrderDTO, wareHouseCategory);

        response.setBatchStock(batch.getListOfProducts());
        response.setBatchId(batch.getId());
        InboundOrder inboundOrder = new InboundOrder(wareHouseCategory.getCategory(), wareHouseCategory.getWareHouse(), batch);

        inboundOrderRepo.save(inboundOrder);

        return response;
    }

    @Override
    public ResponseDTO update(InboundOrderDTO inboundOrderDTO, long representativeId) {
        ResponseDTO responseDTO = new ResponseDTO();

        this.validations(
                inboundOrderDTO.getWareHouseCategory().getWareHouseCode(), //id do armazem
                representativeId, //id do representante
                inboundOrderDTO.getWareHouseCategory().getWareHouseCode() //nome da categoria
        );

        Batch batch = batchService.save(
                inboundOrderDTO,
                wareHouseService.findWareHouseCategoryByWareHouseId(
                        inboundOrderDTO.getWareHouseCategory()
                )
        );

        responseDTO.setBatchStock(
                batch.getListOfProducts()
        );

        responseDTO.setBatchId(batch.getId());

        return responseDTO;
    }

    /***
     * Verifica se o armazem existe e se o representante pode mexer nesse armazem
     * @param wareHouseId armazem id
     * @param representativeId representante id
     * @param categoryName nome da categoria
     */
    private void validations(String wareHouseId, long representativeId, String categoryName){
        if (!wareHouseService.wareHouseExist(wareHouseId)) { //verifica se existe o ware house
            throw new NotFoundExceptionImp("Warehouse not found");
        }

        Representative representative = findRepresentative(representativeId);

        if (!representative.getWareHouse().getId().equals(categoryName)){
            throw new RepresentativeUnauthorizedException("Unauthorized representative");
        }
    }

    private Representative findRepresentative(long id){
        return representativeService.findRepresentativeById(id);
    }
}
