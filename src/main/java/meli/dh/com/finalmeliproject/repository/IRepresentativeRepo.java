package meli.dh.com.finalmeliproject.repository;

import meli.dh.com.finalmeliproject.model.Representative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepresentativeRepo extends JpaRepository<Representative, Long> {
}
