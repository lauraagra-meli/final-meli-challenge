package meli.dh.com.finalmeliproject.repository;

import meli.dh.com.finalmeliproject.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShoppingCartRepo extends JpaRepository<ShoppingCart, Long> {
}
