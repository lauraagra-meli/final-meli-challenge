package meli.dh.com.finalmeliproject.mocks.service;

import meli.dh.com.finalmeliproject.mocks.GenerateBuyer;
import meli.dh.com.finalmeliproject.mocks.repo.BuyerRepoMock;
import meli.dh.com.finalmeliproject.model.Buyer;

public class BuyerServiceMock {
    public static Buyer findById(){
        return GenerateBuyer.newBuyer();
    }
}
