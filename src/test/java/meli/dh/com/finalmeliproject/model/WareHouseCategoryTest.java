package meli.dh.com.finalmeliproject.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        assertThat(wareHouseCategory.getCapacity()).isEqualTo(100);
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

    @Test
    void builder() {
        WareHouseCategory whc = WareHouseCategory.builder().build();
        assertThat(whc).isNotNull();
    }

    @Test
    void doesItFitTrue() {
        WareHouseCategory whc = WareHouseCategory.builder()
                .storage(0)
                .capacity(10)
                .build();

        assertThat(whc.doesItFit(5)).isTrue();
    }

    @Test
    void doesItFitFalse() {
        WareHouseCategory whc = WareHouseCategory.builder()
                .storage(0)
                .capacity(10)
                .build();

        assertThat(whc.doesItFit(100)).isFalse();
    }

    @Test
    void sumStorage() {
        WareHouseCategory whc = WareHouseCategory.builder()
                .storage(0)
                .capacity(10)
                .build();

        whc.sumStorage(10);

        assertThat(whc.getStorage()).isEqualTo(10);
    }

    @Test
    void subStorage() {
        WareHouseCategory whc = WareHouseCategory.builder()
                .storage(5)
                .capacity(10)
                .build();

        whc.subStorage(3);

        assertThat(whc.getStorage()).isEqualTo(2);
    }

    @Test
    void getAndSetStorage() {
        this.wareHouseCategory.setStorage(0);
        assertEquals(wareHouseCategory.getStorage(), 0);
    }

}
