package meli.dh.com.finalmeliproject.mocks.service;

import meli.dh.com.finalmeliproject.mocks.GenerateBatch;
import meli.dh.com.finalmeliproject.model.Batch;

public class BatchServiceMock {
    public static Batch save(){
        return GenerateBatch.newBatchToSave();
    }
}
