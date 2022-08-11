package meli.dh.com.finalmeliproject.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PackageTest {

    @Test
    void getAndSetId() {
        Package pkg = new Package();
        pkg.setId(1);

        assertThat(pkg.getId()).isEqualTo(1);
    }

    @Test
    void getAndSetPackageType() {
        Package pkg = new Package();
        pkg.setPackageType("TEST");

        assertThat(pkg.getPackageType()).isEqualTo("TEST");
    }

    @Test
    void getAndSetStorageCapacity() {
        Package pkg = new Package();
        pkg.setStorageCapacity(1);

        assertThat(pkg.getStorageCapacity()).isEqualTo(1);
    }

    @Test
    void getAndSetCategory() {
        Package pkg = new Package();
        Category cat = new Category();
        pkg.setCategory(cat);

        assertThat(pkg.getCategory()).isEqualTo(cat);
    }

    @Test
    void allConstructor(){
        Package pkg = new Package(
                1,
                "TEST",
                1,
                new Category()
        );

        assertThat(pkg).isNotNull();
    }

    @Test
    void builder(){
        Package pkg = Package.builder().build();
        assertThat(pkg).isNotNull();
    }
}
