package meli.dh.com.finalmeliproject.model;

import org.apache.catalina.LifecycleState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WareHouseCategoryTest {

    private WareHouseCategory wareHouseCategory;
    private Category category;
    private WareHouse wareHouse;

    @BeforeEach
    void setup() {
        wareHouse = new WareHouse("a1", 10, null);
        category = new Category(1, "frescos", 10, 20);
        wareHouseCategory = new WareHouseCategory(1, 100, 0,null, null);
    }

    @Test
    void getId() {
        assertThat(wareHouseCategory.getId()).isEqualTo(1);
    }

    @Test
    void getQuantityMax() {
        assertThat(wareHouseCategory.getCategory()).isEqualTo(100);
    }

    @Test
    void getCategory() {
        wareHouseCategory.setCategory(category);
        assertThat(wareHouseCategory.getCategory()).isEqualTo(category);
    }

    @Test
    void getWareHouse() {
        wareHouseCategory.setWareHouse(wareHouse);
        assertThat(wareHouseCategory.getWareHouse()).isEqualTo(wareHouse);
    }

    @Test
    void setId() {
        wareHouseCategory.setId(1);
        assertThat(wareHouseCategory.getId()).isEqualTo(1);
    }

    @Test
    void setCapacity() {
        wareHouseCategory.setCapacity(100);
        assertThat(wareHouseCategory.getCapacity()).isEqualTo(100);
    }

    @Test
    void setCategory() {
        wareHouseCategory.setCategory(category);
        assertThat(wareHouseCategory.getCategory()).isEqualTo(category);
    }

    @Test
    void setWareHouse() {
        wareHouseCategory.setWareHouse(wareHouse);
        assertThat(wareHouseCategory.getWareHouse()).isEqualTo(wareHouse);
    }

    @Test
    void noConstructor() {
        wareHouseCategory = new WareHouseCategory();
        assertEquals(wareHouseCategory.getId(), 0);
    }
}
