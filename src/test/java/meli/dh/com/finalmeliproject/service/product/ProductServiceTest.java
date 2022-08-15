package meli.dh.com.finalmeliproject.service.product;

import meli.dh.com.finalmeliproject.mocks.GenerateProduct;
import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.repository.IProductRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private IProductRepo productRepo;

    @BeforeEach
    void setup() {
        BDDMockito.when(productRepo.save(ArgumentMatchers.any(Product.class)))
                .thenReturn(GenerateProduct.newProductToSave());

        BDDMockito.when(productRepo.saveAll(ArgumentMatchers.anyList()))
                .thenReturn(GenerateProduct.newListProductToSave());
    }

    @Test
    void save_saveProduct_whenValidProduct() {
        Product product = GenerateProduct.newProductToSave();
        Product productSaved = productService.save(product);

        assertThat(productSaved).isNotNull();
        assertThat(productSaved.getName()).isEqualTo(product.getName());

        verify(productRepo, Mockito.only()).save(product);
    }

    @Test
    void save_saveAll_whenValidProducts() {
        List<Product> product = GenerateProduct.newListProductToSave();
        List<Product> productSaved = productService.saveAll(product);

        assertThat(productSaved).isNotNull();
        assertThat(productSaved.size()).isEqualTo(product.size());
    }
}
