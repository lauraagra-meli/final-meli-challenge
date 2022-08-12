package meli.dh.com.finalmeliproject.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void getAndSetId() {
        ShoppingCart sc = new ShoppingCart();
        sc.setId(1);

        assertThat(sc.getId()).isEqualTo(1);
    }

    @Test
    void getAndSetBuyer() {
        ShoppingCart sc = new ShoppingCart();
        Buyer b = new Buyer();
        sc.setBuyer(b);

        assertThat(sc.getBuyer()).isEqualTo(b);
    }

    @Test
    void getAndSetListOfShoppingProducts() {
        ShoppingCart sc = new ShoppingCart();
        List<ProductShoppingCart> psc = new ArrayList<>();
        sc.setListOfShoppingProducts(psc);

        assertThat(sc.getListOfShoppingProducts()).isEqualTo(psc);
    }

    @Test
    void allConstructor() {
        List<ProductShoppingCart> psc = new ArrayList<>();
        ShoppingCart sc = new ShoppingCart(
                1,
                new Buyer(),
                psc
        );

        assertThat(sc).isNotNull();
    }

}
