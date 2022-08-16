package meli.dh.com.finalmeliproject.repository;

import meli.dh.com.finalmeliproject.model.InboundOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IInboundOrderRepo extends JpaRepository<InboundOrder, Long> {


    @Query(value = "SELECT DISTINCT io.batch.id as batchId, p.id as productId, p.name as productName, c.categoryName as categoryName, p.dueDate as dueDate " +
            "FROM InboundOrder io " +
            "INNER JOIN Category c on c.id = io.category.id " +
            "INNER JOIN Batch b on b.id = io.batch.id " +
            "INNER JOIN Product p on p.batch.id = b.id " +
            "WHERE c.categoryName = :categoryName " +
            "AND p.dueDate >= :dueDate " +
            "ORDER BY p.dueDate")
    List<IFilterByDueDate> findByDueDate(LocalDate dueDate, String categoryName);

    interface IFilterByDueDate {
        long getBatchId();
        String getProductId();
        String getProductName();
        String getCategoryName();
        LocalDate getDueDate();
    }

}
