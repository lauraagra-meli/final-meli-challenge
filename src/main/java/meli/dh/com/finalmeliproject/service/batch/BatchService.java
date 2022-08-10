package meli.dh.com.finalmeliproject.service.batch;

import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.dto.ProductDTO;
import meli.dh.com.finalmeliproject.exception.BadRequestExceptionImp;
import meli.dh.com.finalmeliproject.model.*;
import meli.dh.com.finalmeliproject.repository.IBatchRepo;
import meli.dh.com.finalmeliproject.service.product.IProductService;
import meli.dh.com.finalmeliproject.service.wareHouse.IWareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            if (!(p.getMaxTemperature() < wareHouseCategory.getCategory().getMaxTemperature())){
                throw new BadRequestExceptionImp("Product not allowed in this category, not a proper max temperature.");
            }
            if (!(p.getMinimumTemperature() > wareHouseCategory.getCategory().getMinTemperature())){
                throw new BadRequestExceptionImp("Product not allowed in this category, min temperature not compatible.");
            }

            if(!wareHouseCategory.doesItFit(inboundOrderDTO.getBatchStock().size())){
                throw new BadRequestExceptionImp("The size of the category batch exceeds the limit of the warehouse.");
            }

            wareHouseCategory.subStorage(p.getQuantity());

            Product product = new Product(
                    p.getName(),
                    p.getQuantity(),
                    wareHouseCategory.getCategory(),
                    batch,
                    p.getDueDate(),
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
}
