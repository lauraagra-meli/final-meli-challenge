package meli.dh.com.finalmeliproject.service.product;

import com.sun.istack.Nullable;
import meli.dh.com.finalmeliproject.dto.BatchDTO;
import meli.dh.com.finalmeliproject.dto.ProductBatchDTO;
import meli.dh.com.finalmeliproject.exception.BadRequestExceptionImp;
import meli.dh.com.finalmeliproject.exception.NotFoundExceptionImp;
import meli.dh.com.finalmeliproject.model.Batch;
import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;
import meli.dh.com.finalmeliproject.repository.IBatchRepo;
import meli.dh.com.finalmeliproject.repository.IProductRepo;
import meli.dh.com.finalmeliproject.repository.IWareHouseProductRepo;
import meli.dh.com.finalmeliproject.service.buyer.IBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IWareHouseProductRepo iWareHouseProductRepo;

    @Autowired
    private IProductRepo repo;

    @Autowired
    private IBuyerService buyerService;

    public Product save(Product product) {
        return repo.save(product);
    }

    @Override
    public List<Product> saveAll(List<Product> products) {
        return repo.saveAll(products);
    }

    @Override
    public List<Product> findAllProducts() {
        List<Product> products = repo.findAll();

        if (products.size() == 0) {
            throw new NotFoundExceptionImp("Dont exist products");
        }

        return products;
    }

    @Override
    public int checkStock(String id) {
        try {
            WareHouseProduct product = iWareHouseProductRepo.findByProductId(id);
            return product.getQuantity();
        } catch (Exception ex) {
            throw new NotFoundExceptionImp("Product not found");
        }
    }

    @Override
    public List<Product> findProductsByCategory(String category) {
        List<Product> productsByCategory = repo.findAll().stream()
                .filter(product -> product.getCategory().getCategoryName().equals(category))
                .collect(Collectors.toList());

        if (productsByCategory.isEmpty()) {
            throw new NotFoundExceptionImp("Category not found.");
        }
        return productsByCategory;
    }

    //FEATURE 03
    @Override
    public List<ProductBatchDTO> allProductsPerBatch(String id) {

        List<ProductBatchDTO> response = repo.allProductsPerBatch(id).stream()
                .map(ProductBatchDTO::new)
                .collect(Collectors.toList());
        if (response.isEmpty()) {
            throw new NotFoundExceptionImp("Product id not found");
        }
        return response;
    }

    public List<Product> filterProductsByBatch (String productId, String order){
        repo.findById(productId);

        switch (order) {
            case "B":
                return repo.findAll()
                        .stream()
                        .sorted((b1, b2) -> b1.compareToBatch(b2))
                        .collect(Collectors.toList());
            case "Q":
                return repo.findAll()
                        .stream()
                        .sorted()
                        .collect(Collectors.toList());
                // TODO: fazer query para pegar a quantidade
            case "D":
                return repo.findAll()
                        .stream()
                        .sorted((d1, d2) -> d1.getDueDate().compareTo(d2.getDueDate()))
                        .collect(Collectors.toList());
            default:
                throw new BadRequestExceptionImp("Order not found");
        }
    }


    public WareHouseProduct findByProductId(String id) {
        WareHouseProduct product = iWareHouseProductRepo.findByProductId(id);
        return product;
    }

}
