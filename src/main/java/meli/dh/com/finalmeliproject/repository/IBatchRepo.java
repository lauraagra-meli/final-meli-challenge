package meli.dh.com.finalmeliproject.repository;

import meli.dh.com.finalmeliproject.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBatchRepo extends JpaRepository<Batch, Long> {
}
