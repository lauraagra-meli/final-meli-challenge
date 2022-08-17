package meli.dh.com.finalmeliproject.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BatchTest {

    private Batch batch;
    private List<Product> productList;
    private List<InboundOrder> inboundOrderList;

    @BeforeEach
    void setup() {
        productList = new ArrayList<>();
        inboundOrderList = new ArrayList<>();
        productList.add(new Product("MELI12321", "TEST", 10, null, null, LocalDate.of(2023, 01, 12), LocalDateTime.now()));
        inboundOrderList.add(new InboundOrder(1, LocalDateTime.now(), null, null, null));

        batch = new Batch(1, LocalDate.now(),null);
    }

    @Test
    void getId() {
        assertThat(batch.getId()).isEqualTo(1);
    }

    @Test
    void getListOfProducts() {
        batch.setListOfProducts(productList);
        assertThat(batch.getListOfProducts()).isEqualTo(productList);
    }

    @Test
    void setId() {
        batch.setId(1);
        assertThat(batch.getId()).isEqualTo(1);
    }

    @Test
    void setListOfProducts() {
        batch.setListOfProducts(productList);
        assertThat(batch.getListOfProducts()).isEqualTo(productList);
    }

    @Test
    void noConstructor() {
        batch = new Batch();
        assertEquals(batch.getId(), 0);
    }

    @Test
    void builderTest() {
        batch = Batch.builder().build();
        assertEquals(batch.getId(), 0);
    }
}
