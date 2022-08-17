package meli.dh.com.finalmeliproject.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RepresentativeTest {

    @Test
    void getAndSetId() {
        Representative r = new Representative();
        r.setId(1);
        assertThat(r.getId()).isEqualTo(1);
    }

    @Test
    void getAndSetName() {
        Representative r = new Representative();
        r.setName("TEST");
        assertThat(r.getName()).isEqualTo("TEST");
    }

    @Test
    void getAndSetWareHouse() {
        Representative r = new Representative();
        WareHouse wh = new WareHouse();
        r.setWareHouse(wh);
        assertThat(r.getWareHouse()).isEqualTo(wh);
    }

    @Test
    void allContructor() {
        Representative r = new Representative(
                1,
                "TEST",
                new WareHouse()
        );

        assertThat(r).isNotNull();
    }

    @Test
    void builder() {
        Representative r = Representative.builder().build();
        assertThat(r).isNotNull();
    }

}
