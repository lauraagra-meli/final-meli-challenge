package meli.dh.com.finalmeliproject.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    private Category category;

    private final List<ShippingCategory> shippingCategoryList = new ArrayList<>();
    private final List<Package> packageList = new ArrayList<>();
    private final List<Product> productList = new ArrayList<>();
    private final List<InboundOrder> inboundOrderList = new ArrayList<>();

    @BeforeEach
    void setup() {
        shippingCategoryList.add(new ShippingCategory(1, 100, null, null));
        packageList.add(new Package(1, "caixa", 20, null));
        productList.add(new Product("MELI20932", "TEST", 10, null, null, LocalDate.of(2023, 02, 01), LocalDateTime.now()));
        inboundOrderList.add(new InboundOrder(1, LocalDateTime.now(), null, null, null));

        category = new Category(1, "congelados", -20, 0);
    }

    @Test
    void getId() {
        assertThat(category.getId()).isEqualTo(1);
    }

    @Test
    void getCategoryName() {
        assertThat(category.getCategoryName()).isEqualTo("congelados");
    }

    @Test
    void getMinTemperature() {
        assertThat(category.getMinTemperature()).isEqualTo(-20);
    }

    @Test
    void getMaxTemperature() {
        assertThat(category.getMinTemperature()).isEqualTo(-20);
    }

    @Test
    void setId() {
        category.setId(1);
        assertThat(category.getId()).isEqualTo(1);
    }

    @Test
    void setCategoryName() {
        category.setCategoryName("congelados");
        assertThat(category.getCategoryName()).isEqualTo("congelados");
    }

    @Test
    void setMinTemperature() {
        category.setMinTemperature(-15);
        assertThat(category.getMinTemperature()).isEqualTo(-15);
    }

    @Test
    void setMaxTemperature() {
        category.setMaxTemperature(0);
        assertThat(category.getMaxTemperature()).isEqualTo(0);
    }

    @Test
    void noConstructor() {
        category = new Category();
        assertEquals(category.getId(), 0);
    }

    @Test
    void builderTest() {
        category = Category.builder().build();
        assertEquals(category.getId(), 0);
    }
}
