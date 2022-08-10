package meli.dh.com.finalmeliproject.service.product;

import meli.dh.com.finalmeliproject.dto.ProductDTO;
import meli.dh.com.finalmeliproject.exception.NotFoundExceptionImp;
import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.repository.IProductRepo;
import meli.dh.com.finalmeliproject.service.buyer.IBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

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
    public List<Product> findAll(long buyerId) {
        if (!buyerService.buyerExist(buyerId)){
            throw new NotFoundExceptionImp("Not exist buyer with id " + buyerId);
        };

        List<Product> products = repo.findAll();

        if (products.size() == 0) {
            throw new NotFoundExceptionImp("Dont exist products");
        }

        return products;
    }

    @Override
    public List<ProductDTO> getAllProducts(long buyerId) {
        return findAll(buyerId).stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    public ProductDTO checkStock(String id) {
        List<ProductDTO> allProducts = getAllProducts(0);
        ProductDTO productDTO = allProducts.stream().filter(p -> p.getProductId().equals(id)).findFirst().orElse(null);

        if (productDTO == null) {
            throw new NotFoundExceptionImp("Product not found");
        }

        return productDTO;
    }

}
