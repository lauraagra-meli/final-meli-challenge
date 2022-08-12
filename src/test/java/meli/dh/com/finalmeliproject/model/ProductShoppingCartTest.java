package meli.dh.com.finalmeliproject.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductShoppingCartTest {

    @Test
    void getAndSetId() {
        ProductShoppingCart psc = new ProductShoppingCart();
        psc.setId(1);
        assertThat(psc.getId()).isEqualTo(1);
    }

    @Test
    void getAndSetProductQuantity() {
        ProductShoppingCart psc = new ProductShoppingCart();
        psc.setProductQuantity(1);
        assertThat(psc.getProductQuantity()).isEqualTo(1);
    }

    @Test
    void getAndSetProduct() {
        ProductShoppingCart psc = new ProductShoppingCart();
        Product p = new Product();
        psc.setProduct(p);
        assertThat(psc.getProduct()).isEqualTo(p);
    }

    @Test
    void getAndSetShoppingCart() {
        ProductShoppingCart psc = new ProductShoppingCart();
        ShoppingCart sp = new ShoppingCart();
        psc.setShoppingCart(sp);
        assertThat(psc.getShoppingCart()).isEqualTo(sp);
    }

    @Test
    void allConstructor() {
        ProductShoppingCart psc = new ProductShoppingCart(
                1,
                1,
                new Product(),
                new ShoppingCart()
        );

        assertThat(psc).isNotNull();
    }
}
