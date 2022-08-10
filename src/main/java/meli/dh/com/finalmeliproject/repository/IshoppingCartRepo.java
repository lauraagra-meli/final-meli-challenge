package meli.dh.com.finalmeliproject.repository;

import meli.dh.com.finalmeliproject.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IshoppingCartRepo extends JpaRepository<ShoppingCart, Long> {
}
