package meli.dh.com.finalmeliproject.service.batch;

import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.dto.ProductDTO;
import meli.dh.com.finalmeliproject.exception.BadRequestExceptionImp;
import meli.dh.com.finalmeliproject.exception.NotFoundExceptionImp;
import meli.dh.com.finalmeliproject.model.*;
import meli.dh.com.finalmeliproject.repository.IBatchRepo;
import meli.dh.com.finalmeliproject.service.product.IProductService;
import meli.dh.com.finalmeliproject.service.wareHouse.IWareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BatchService implements IBatchService{

    @Autowired
    private IProductService productService;

    @Autowired
    private IWareHouseService wareHouseService;

    @Autowired
    private IBatchRepo batchRepo;

    @Override
    public Batch save(InboundOrderDTO inboundOrderDTO, WareHouseCategory wareHouseCategory) {

        Batch batch = new Batch();
        List<Product> products = new ArrayList<>();
        List<WareHouseProduct> wareHouseProducts = new ArrayList<>();

        // comparando as temperaturas de cada um dos produtosDTO com as temperaturas da categorias
        // verifica se os produtos estao de acordo com as especificacoes da categoria informada
        for (ProductDTO p : inboundOrderDTO.getBatchStock()) {
            if (!(p.getMaxTemperature() <= wareHouseCategory.getCategory().getMaxTemperature())){
                throw new BadRequestExceptionImp("Product not allowed in this category, not a proper max temperature.");
            }
            if (!(p.getMinimumTemperature() >= wareHouseCategory.getCategory().getMinTemperature())){
                throw new BadRequestExceptionImp("Product not allowed in this category, min temperature not compatible.");
            }

            if(!wareHouseCategory.doesItFit(inboundOrderDTO.getBatchStock().size())){
                throw new BadRequestExceptionImp("The size of the category batch exceeds the limit of the warehouse.");
            }

            wareHouseCategory.sumStorage(p.getQuantity());

            Product product = new Product(
                    p.getName(),
                    p.getPrice(),
                    wareHouseCategory.getCategory(),
                    batch,
                    inboundOrderDTO.getDueDate(),
                    p.getManufacturingDate()
            );

            WareHouseProduct wareHouseProduct = new WareHouseProduct(
                    p.getQuantity(),
                    product,
                    wareHouseCategory.getWareHouse()
            );

            p.setProductId(product.getId());

            wareHouseProducts.add(wareHouseProduct);
            products.add(product);
        }

        batch.setListOfProducts(products);

        batch.setId(inboundOrderDTO.getBatchId());
        if (batch.getId() == 0){
            batch.setDueDate(inboundOrderDTO.getDueDate());
            batch.setId(batchRepo.save(batch).getId());
        }

        productService.saveAll(products);
        wareHouseService.saveAll(wareHouseProducts);
        wareHouseService.update(wareHouseCategory);

        return batch;
    }

    @Override
    public Batch findById(long batchId) {
        return batchRepo.findById(batchId).get();
    }

    @Override
    public List<Batch> findByDueDate(String categoryName, int amountDay) {
        LocalDate filter = LocalDate.now();
        filter = filter.plusDays(amountDay);

        List<Batch> batches = batchRepo.findAllByDueDateAfter(filter);
        List<Batch> batchesFilter = new ArrayList<>();

        for (Batch b : batches) {
            if (b.getListOfProducts().size() == 0 ) {
                continue;
            }
            if (b.getListOfProducts().get(0).getCategory().getCategoryName().equals(categoryName)){
                batchesFilter.add(b);
            }
        }

        if (batchesFilter.size() == 0 ) {
            throw new NotFoundExceptionImp("Not exist products with this features. | dueDate after: " + filter.toString() + " | categoryName: " + categoryName);
        }
        return batchesFilter;
    }
}
