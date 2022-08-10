package meli.dh.com.finalmeliproject.repository;

import meli.dh.com.finalmeliproject.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBuyerRepo extends JpaRepository<Buyer, Long> {
}
