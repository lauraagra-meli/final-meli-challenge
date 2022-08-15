package meli.dh.com.finalmeliproject;

import meli.dh.com.finalmeliproject.dto.BatchDTO;
import meli.dh.com.finalmeliproject.mocks.GenerateProduct;

public class GenerateBatchDTO {
    public static BatchDTO newBatchDTO(){
        return new BatchDTO(
                1,
                GenerateProduct.newListProductToSave());
    }
}
