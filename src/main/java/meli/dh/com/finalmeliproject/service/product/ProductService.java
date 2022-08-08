package meli.dh.com.finalmeliproject.service.product;

import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepo repo;

    public Product save(Product product) {
        return repo.save(product);
    }

}
