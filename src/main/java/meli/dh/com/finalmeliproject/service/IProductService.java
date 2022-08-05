package meli.dh.com.finalmeliproject.service;

import meli.dh.com.finalmeliproject.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface IProductService {
    Product save(Product product);
}
