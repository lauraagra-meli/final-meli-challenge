package meli.dh.com.finalmeliproject.repository;

import meli.dh.com.finalmeliproject.model.InboundOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInboundOrderRepo extends JpaRepository<InboundOrder, Long> {
}
