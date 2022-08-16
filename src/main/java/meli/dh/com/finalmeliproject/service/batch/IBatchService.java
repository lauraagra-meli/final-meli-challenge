package meli.dh.com.finalmeliproject.service.batch;

import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.dto.ResponseDTO;
import meli.dh.com.finalmeliproject.model.Batch;
import meli.dh.com.finalmeliproject.model.Category;
import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.model.WareHouseCategory;

import java.time.LocalDate;
import java.util.List;

public interface IBatchService {
    Batch save(InboundOrderDTO inboundOrderDTO, WareHouseCategory wareHouseCategory);
    Batch findById(long batchId);
    List<Batch> findByDueDate(String categoryName, int amountDay);
}
