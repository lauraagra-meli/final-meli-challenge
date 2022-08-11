package meli.dh.com.finalmeliproject.mocks.repo;

import meli.dh.com.finalmeliproject.mocks.GenerateBatch;
import meli.dh.com.finalmeliproject.model.Batch;

import java.util.Optional;

public class BatchRepoMock {
    public static Batch save() {
        return GenerateBatch.newBatchToSave();
    }

    public static Optional<Batch> findById() {
        return Optional.of(GenerateBatch.newBatchToSave());
    }
}
