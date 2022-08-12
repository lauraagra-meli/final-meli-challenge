package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.model.Batch;

public class GenerateBatch {

    public static Batch newBatchToSave() {
        Batch batch = Batch.builder()
                .id(1)
                .listOfProducts(GenerateProduct.newListProductToSave())
                .build();
        return batch;
    }
}
