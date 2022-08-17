package meli.dh.com.finalmeliproject.controller;

import meli.dh.com.finalmeliproject.service.shoppingCart.IShoppingCartService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ProductControllerTest {

    @InjectMocks
    private ShoppingCartController shoppingCartController;

    @Mock
    private IShoppingCartService service;

    @Test
    void findProductsList() {

    }

    @Test
    void checkStock() {
    }

    @Test
    void listingProductsByCategory() {
    }

    @Test
    void allProductsPerBatch() {
    }

    @Test
    void filterProductsPerBatch() {
    }

    @Test
    void findByDueDate() {
    }

    @Test
    void findByBatchsDueDate() {
    }
}