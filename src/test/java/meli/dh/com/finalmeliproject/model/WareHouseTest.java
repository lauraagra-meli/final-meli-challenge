package meli.dh.com.finalmeliproject.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WareHouseTest {

    @Test
    void getAndSetId() {
        WareHouse wh = new WareHouse();
        wh.setId("TEST");

        assertThat(wh.getId()).isEqualTo("TEST");
    }

    @Test
    void getAndSetStorageCapacity() {
        WareHouse wh = new WareHouse();
        wh.setStorageCapacity(1);

        assertThat(wh.getStorageCapacity()).isEqualTo(1);
    }

    @Test
    void getAndSetListOfWareHouseCategory() {
        WareHouse wh = new WareHouse();
        List<WareHouseCategory> c = new ArrayList<>();
        wh.setListOfWareHouseCategory(c);

        assertThat(wh.getListOfWareHouseCategory()).isEqualTo(c);
    }

    @Test
    void allConstructor() {
        List<WareHouseCategory> whc = new ArrayList<>();
        WareHouse wh = new WareHouse(
                "TEST",
                1,
                whc
        );

        assertThat(wh).isNotNull();
    }


    @Test
    void builder() {
        WareHouse wh = WareHouse.builder().build();
        assertThat(wh).isNotNull();
    }
}
