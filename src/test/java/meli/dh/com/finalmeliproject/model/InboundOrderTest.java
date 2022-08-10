package meli.dh.com.finalmeliproject.model;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class InboundOrderTest {

    @Test
    void getOrderNumber() {
        InboundOrder inboundOrder = new InboundOrder();

        assertThat(inboundOrder.getOrderNumber()).isEqualTo(0);
    }

    @Test
    void getOrderDate() {
        InboundOrder inboundOrder = new InboundOrder();
        LocalDateTime orderDate = LocalDateTime.now();
        inboundOrder.setOrderDate(orderDate);

        assertThat(inboundOrder.getOrderDate()).isEqualTo(orderDate);
    }

    @Test
    void getCategory() {
        InboundOrder inboundOrder = new InboundOrder();
        assertThat(inboundOrder.getCategory()).isNull();
    }

    @Test
    void getWareHouse() {
        InboundOrder inboundOrder = new InboundOrder();
        assertThat(inboundOrder.getWareHouse()).isNull();
    }

    @Test
    void getBatch() {
        InboundOrder inboundOrder = new InboundOrder();
        assertThat(inboundOrder.getBatch()).isNull();
    }

    @Test
    void setOrderNumber() {
        InboundOrder inboundOrder = new InboundOrder();
        inboundOrder.setOrderNumber(14);

        assertThat(inboundOrder.getOrderNumber()).isEqualTo(14);
    }

    @Test
    void setOrderDate() {
        InboundOrder inboundOrder = new InboundOrder();
        LocalDateTime orderDate = LocalDateTime.now();
        inboundOrder.setOrderDate(orderDate);

        assertThat(inboundOrder.getOrderDate()).isEqualTo(orderDate);
    }

    @Test
    void setCategory() {
        InboundOrder inboundOrder = new InboundOrder();
        Category category = new Category();
        inboundOrder.setCategory(category);

        assertThat(inboundOrder.getCategory()).isEqualTo(category);
    }

    @Test
    void setWareHouse() {
        InboundOrder inboundOrder = new InboundOrder();
        WareHouse wh = new WareHouse();
        inboundOrder.setWareHouse(wh);

        assertThat(inboundOrder.getWareHouse()).isEqualTo(wh);
    }

    @Test
    void setBatch() {
        InboundOrder inboundOrder = new InboundOrder();
        Batch bt = new Batch();
        inboundOrder.setBatch(bt);

        assertThat(inboundOrder.getBatch()).isEqualTo(bt);
    }

    @Test
    void constructor(){
        InboundOrder inboundOrder = new InboundOrder(new Category(), new WareHouse(), new Batch());
        assertThat(inboundOrder).isNotNull();
    }

    @Test
    void allConstructor(){
        InboundOrder inboundOrder = new InboundOrder(1, LocalDateTime.now(), new Category(), new WareHouse(), new Batch());
        assertThat(inboundOrder).isNotNull();
    }

    @Test
    void builder(){
        InboundOrder inboundOrder = InboundOrder.builder().build();
        assertThat(inboundOrder).isNotNull();
    }
}
