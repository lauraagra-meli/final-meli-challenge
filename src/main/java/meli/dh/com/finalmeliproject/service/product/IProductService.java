package meli.dh.com.finalmeliproject.service.product;

import meli.dh.com.finalmeliproject.model.Product;

import java.util.List;

public interface IProductService {
    Product save(Product product);
    List<Product> saveAll(List<Product> products);
    List<Product> findAll(long buyerId);
}
