package meli.dh.com.finalmeliproject.service.product;

import meli.dh.com.finalmeliproject.dto.ProductBatchDTO;
import meli.dh.com.finalmeliproject.dto.ProductsBatchFilter;
import meli.dh.com.finalmeliproject.exception.NotFoundExceptionImp;
import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;
import meli.dh.com.finalmeliproject.repository.IInboundOrderRepo;
import meli.dh.com.finalmeliproject.repository.IProductRepo;
import meli.dh.com.finalmeliproject.repository.IWareHouseProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IWareHouseProductRepo iWareHouseProductRepo;

    @Autowired
    private IProductRepo repo;

    @Autowired
    private IInboundOrderRepo inboundOrderRepo;

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

    public WareHouseProduct findByProductId(String id) {
        return iWareHouseProductRepo.findByProductId(id);
    }

    @Override
    public List<ProductsBatchFilter> findFilter(int amountDays, String categoryName) {

        LocalDate filterDate = LocalDate.now();
        filterDate = filterDate.plusDays(amountDays);

        List<ProductsBatchFilter> productsBatchFilters = inboundOrderRepo.findByDueDate(filterDate, categoryName).stream().map(ProductsBatchFilter::new).collect(Collectors.toList());
        if (productsBatchFilters.size() == 0) {
            throw new NotFoundExceptionImp("Not exist products with this features. | dueDate: " + filterDate.toString() + " | categoryName: " + categoryName);
        }
        return productsBatchFilters;
    }

}
