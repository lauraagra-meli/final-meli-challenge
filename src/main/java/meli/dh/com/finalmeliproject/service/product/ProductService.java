package meli.dh.com.finalmeliproject.service.product;

import meli.dh.com.finalmeliproject.dto.ProductBatchDTO;
import meli.dh.com.finalmeliproject.dto.ProductDTO;
import meli.dh.com.finalmeliproject.exception.BadRequestExceptionImp;
import meli.dh.com.finalmeliproject.exception.NotFoundExceptionImp;
import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;
import meli.dh.com.finalmeliproject.repository.IProductRepo;
import meli.dh.com.finalmeliproject.repository.IWareHouseProductRepo;
import meli.dh.com.finalmeliproject.service.buyer.IBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
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
        }catch (Exception ex){
            throw new NotFoundExceptionImp("Product not found");
        }
    }

    @Override
    public List<Product> findProductsByCategory(String category) {
        List<Product> productsByCategory =  repo.findAll().stream()
                .filter(product -> product.getCategory().getCategoryName().equals(category))
                .collect(Collectors.toList());

        if (productsByCategory.isEmpty()){
            throw new NotFoundExceptionImp("Category not found.");
        }
        return productsByCategory;
    }

    //FEATURE 03
    @Override
    public ProductBatchDTO allProductsInWarehouse(String id) {
        return null;
    }

    public WareHouseProduct findByProductId(String id){
        WareHouseProduct product =iWareHouseProductRepo.findByProductId(id);

        return product;
    }

}
