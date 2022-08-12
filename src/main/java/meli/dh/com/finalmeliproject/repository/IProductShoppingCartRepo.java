package meli.dh.com.finalmeliproject.repository;

import meli.dh.com.finalmeliproject.model.ProductShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductShoppingCartRepo extends JpaRepository<ProductShoppingCart, Long> {
}
