package meli.dh.com.finalmeliproject.repository;

import meli.dh.com.finalmeliproject.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPurchaseOrderRepo extends JpaRepository<PurchaseOrder, Long> {
}
