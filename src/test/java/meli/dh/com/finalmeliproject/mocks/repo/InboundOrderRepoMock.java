package meli.dh.com.finalmeliproject.mocks.repo;

import meli.dh.com.finalmeliproject.mocks.GenerateInboundOrder;
import meli.dh.com.finalmeliproject.model.InboundOrder;

public class InboundOrderRepoMock {
    public static InboundOrder save(){
        return GenerateInboundOrder.newInboundOrder();
    }
}
