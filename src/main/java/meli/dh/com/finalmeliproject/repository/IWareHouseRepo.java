package meli.dh.com.finalmeliproject.repository;

import meli.dh.com.finalmeliproject.model.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWareHouseRepo extends JpaRepository<WareHouse, String> {
}
