package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.model.InboundOrder;

import java.time.LocalDateTime;

public class GenerateInboundOrder {
    public static InboundOrder newInboundOrder(){
        return new InboundOrder(
                1,
                LocalDateTime.now(),
                GenerateCategory.newCategoryToSave(),
                GenerateWareHouse.newWareHouse(),
                GenerateBatch.newBatchToSave()
        );
    }
}
