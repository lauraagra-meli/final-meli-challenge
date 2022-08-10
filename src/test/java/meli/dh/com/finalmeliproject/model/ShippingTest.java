package meli.dh.com.finalmeliproject.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ShippingTest {

    @Test
    void getAndSetId() {
        Shipping s = new Shipping();
        s.setId(1);

        assertThat(s.getId()).isEqualTo(1);
    }

    @Test
    void getAndSetShippingCapacity() {
        Shipping s = new Shipping();
        s.setShippingCapacity(1);

        assertThat(s.getShippingCapacity()).isEqualTo(1);
    }

    @Test
    void getAndSetShippingCategoryList() {
        Shipping s = new Shipping();
        List<ShippingCategory> categories = new ArrayList<>();
        s.setShippingCategoryList(categories);

        assertThat(s.getShippingCategoryList()).isEqualTo(categories);
    }

    @Test
    void allConstructor() {
        List<ShippingCategory> categories = new ArrayList<>();
        Shipping s = new Shipping(
                1,
                1,
                categories
        );

        assertThat(s).isNotNull();
    }

    @Test
    void builder() {
        Shipping s = Shipping.builder().build();

        assertThat(s).isNotNull();
    }

}
