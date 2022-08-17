package meli.dh.com.finalmeliproject.mocks.repo;

import meli.dh.com.finalmeliproject.GenerateBatchDTO;
import meli.dh.com.finalmeliproject.dto.BatchDTO;
import meli.dh.com.finalmeliproject.mocks.GenerateBatch;
import meli.dh.com.finalmeliproject.model.Batch;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BatchRepoMock {
    public static Batch save() {
        return GenerateBatch.newBatchToSave();
    }

    public static Optional<Batch> findById() {
        return Optional.of(GenerateBatch.newBatchToSave());
    }

    public static List<BatchDTO> findByIdAllProducts() {
        List<BatchDTO> batches = new ArrayList<>();
        batches.add(GenerateBatchDTO.newBatchDTO());
        return batches;
    }


}
