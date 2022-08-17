package meli.dh.com.finalmeliproject.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ShippingCategoryTest {

    @Test
    void getAndSetId() {
        ShippingCategory sc = new ShippingCategory();
        sc.setId(1);

        assertThat(sc.getId()).isEqualTo(1);
    }

    @Test
    void getAndSetQuantityMax() {
        ShippingCategory sc = new ShippingCategory();
        sc.setQuantityMax(1);

        assertThat(sc.getQuantityMax()).isEqualTo(1);
    }

    @Test
    void getAndSetCategory() {
        ShippingCategory sc = new ShippingCategory();
        Category c = new Category();
        sc.setCategory(c);

        assertThat(sc.getCategory()).isEqualTo(c);
    }

    @Test
    void getAndSetShipping() {
        ShippingCategory sc = new ShippingCategory();
        Shipping s = new Shipping();
        sc.setShipping(s);

        assertThat(sc.getShipping()).isEqualTo(s);
    }

    @Test
    void allContructs() {
        ShippingCategory sc = new ShippingCategory(
                1,
                1,
                new Category(),
                new Shipping()
        );

        assertThat(sc).isNotNull();
    }

    @Test
    void builder() {
        ShippingCategory sc = ShippingCategory.builder().build();
        assertThat(sc).isNotNull();
    }
}
