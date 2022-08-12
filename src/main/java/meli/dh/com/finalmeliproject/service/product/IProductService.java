package meli.dh.com.finalmeliproject.service.product;

import meli.dh.com.finalmeliproject.dto.ProductDTO;
import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;

import java.util.List;

public interface IProductService {
    Product save(Product product);
    List<Product> saveAll(List<Product> products);

    List<Product> findAllProducts();
    Product checkStock(String id);

    List<Product> findProductsByCategory(String category);

    WareHouseProduct findByProductId(String id);

}
