package meli.dh.com.finalmeliproject.service.product;

import meli.dh.com.finalmeliproject.dto.ProductBatchDTO;
import meli.dh.com.finalmeliproject.dto.ProductDTO;
import meli.dh.com.finalmeliproject.dto.TestDTO;
import meli.dh.com.finalmeliproject.model.Product;
import org.springframework.http.ResponseEntity;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;
import java.util.List;

public interface IProductService {
    Product save(Product product);
    List<Product> saveAll(List<Product> products);

    List<Product> findAllProducts();
    int checkStock(String id);

    List<Product> findProductsByCategory(String category);

    List<TestDTO> allProductsInWarehouse(String id);

    WareHouseProduct findByProductId(String id);

}
