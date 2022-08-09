package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.model.Batch;

public class GenerateBatch {

    public static Batch newBatchToSave() {
        return Batch.builder()
                .id(2)
                .listOfProducts(null)
                //.listOfInboundOrders()
                .build();
    }
}
