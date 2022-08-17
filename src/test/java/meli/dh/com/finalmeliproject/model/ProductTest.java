package meli.dh.com.finalmeliproject.model;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {

    @Test
    void getAndSetId() {
        Product p = new Product();
        p.setId("TEST");

        assertThat(p.getId()).isEqualTo("TEST");
    }

    @Test
    void getAndSetName() {
        Product p = new Product();
        p.setName("TEST");

        assertThat(p.getName()).isEqualTo("TEST");
    }

    @Test
    void getAndSetCategory() {
        Product p = new Product();
        Category c = new Category();
        p.setCategory(c);

        assertThat(p.getCategory()).isEqualTo(c);
    }

    @Test
    void getAndSetBatch() {
        Product p = new Product();
        Batch b = new Batch();
        p.setBatch(b);

        assertThat(p.getBatch()).isEqualTo(b);
    }

    @Test
    void getAndSetDueDate() {
        Product p = new Product();
        LocalDate ld = LocalDate.now();
        p.setDueDate(ld);

        assertThat(p.getDueDate()).isEqualTo(ld);

    }

    @Test
    void getAndSetManufacturingDate() {
        Product p = new Product();
        LocalDateTime ldt = LocalDateTime.now();
        p.setManufacturingDate(ldt);

        assertThat(p.getManufacturingDate()).isEqualTo(ldt);
    }

    @Test
    void allConstructor(){
        Product p = new Product(
                "TEST",
                "TEST",
                1,
                new Category(),
                new Batch(),
                LocalDate.now(),
                LocalDateTime.now());

        assertThat(p).isNotNull();
    }

    @Test
    void customConstructor(){
        Product p = new Product(
                "TEST",
                1,
                new Category(),
                new Batch(),
                LocalDate.now(),
                LocalDateTime.now());

        assertThat(p).isNotNull();
    }

    @Test
    void builder(){
        Product p = Product.builder().build();
        assertThat(p).isNotNull();
    }
}
