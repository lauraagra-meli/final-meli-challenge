package meli.dh.com.finalmeliproject.service.Product;

import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.repository.IProductRepo;
import meli.dh.com.finalmeliproject.util.GenerateProduct;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private IProductRepo productRepo;

    @Test
    void save_saveProduct_whenValidProduct() {
        BDDMockito.when(productRepo.save(ArgumentMatchers.any(Product.class)))
                .thenReturn(GenerateProduct.newProductToSave());

        Product product = GenerateProduct.newProductToSave();
        Product productSaved = productService.save(product);

        assertThat(productSaved).isNotNull();
        assertThat(productSaved.getName()).isEqualTo(product.getName());

        verify(productRepo, Mockito.only()).save(product);
    }
}