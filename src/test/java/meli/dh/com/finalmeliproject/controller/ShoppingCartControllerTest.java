package meli.dh.com.finalmeliproject.controller;

import meli.dh.com.finalmeliproject.dto.shoppingCart.ResponseShoppingCartDto;
import meli.dh.com.finalmeliproject.mocks.GenerateProduct;
import meli.dh.com.finalmeliproject.mocks.GenerateProductShoppingCart;
import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.model.ProductShoppingCart;
import meli.dh.com.finalmeliproject.model.PurchaseOrder;
import meli.dh.com.finalmeliproject.service.product.IProductService;
import meli.dh.com.finalmeliproject.service.shoppingCart.IShoppingCartService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ShoppingCartControllerTest {

    @InjectMocks
    private ShoppingCartController shoppingCartController;

    @Mock
    private IProductService productService;

    @Mock
    private IShoppingCartService shoppingCartService;

    @Test
    void shoppingCart() {
        BDDMockito.when(productService.save(ArgumentMatchers.any(Product.class)))
                .thenReturn(GenerateProduct.newProductToSave());
    }

    @Test
    void findAllShoppingCartProducts() {
    }

    @Test
    void editPurchaseOrderStatus() {
    }

    @Test
    void updateProductQuantityShoppingCart() {
        BDDMockito.when(shoppingCartService.updateProductQuantityShoppingCart(ArgumentMatchers.anyLong(), ArgumentMatchers.anyMap()))
                .thenReturn(GenerateProductShoppingCart.newProductShoppingCart());
        Map<String, Long> changes = Map.of("productQuantity", 1L);

        ResponseEntity<ProductShoppingCart> response = shoppingCartController.updateProductQuantityShoppingCart(1L, changes);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
}