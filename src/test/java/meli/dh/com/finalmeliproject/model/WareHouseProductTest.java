package meli.dh.com.finalmeliproject.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WareHouseProductTest {

    @Test
    void getAndSetId() {
        WareHouseProduct whp = new WareHouseProduct();
        whp.setId(1);

        assertThat(whp.getId()).isEqualTo(1);
    }

    @Test
    void getAndSetQuantity() {
        WareHouseProduct whp = new WareHouseProduct();
        whp.setQuantity(1);

        assertThat(whp.getQuantity()).isEqualTo(1);
    }

    @Test
    void getAndSetProduct() {
        WareHouseProduct whp = new WareHouseProduct();
        Product p = new Product();
        whp.setProduct(p);

        assertThat(whp.getProduct()).isEqualTo(p);
    }

    @Test
    void getAndSetWareHouse() {
        WareHouseProduct whp = new WareHouseProduct();
        WareHouse wh = new WareHouse();
        whp.setWareHouse(wh);

        assertThat(whp.getWareHouse()).isEqualTo(wh);
    }

    @Test
    void allConstructor() {
        WareHouseProduct whp = new WareHouseProduct(
                1,
                1,
                new Product(),
                new WareHouse()
        );

        assertThat(whp).isNotNull();
    }

    @Test
    void custonConstructor() {
        WareHouseProduct whp = new WareHouseProduct(
                1,
                new Product(),
                new WareHouse()
        );

        assertThat(whp).isNotNull();
    }
}
