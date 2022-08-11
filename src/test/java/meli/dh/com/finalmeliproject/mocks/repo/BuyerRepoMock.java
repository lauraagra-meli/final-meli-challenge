package meli.dh.com.finalmeliproject.mocks.repo;

import meli.dh.com.finalmeliproject.mocks.GenerateBuyer;
import meli.dh.com.finalmeliproject.model.Buyer;

import java.util.Optional;

public class BuyerRepoMock {
    public static Optional<Buyer> findById(){
        return Optional.of(GenerateBuyer.newBuyer());
    }

    public static Optional<Buyer> exist(){
        return Optional.of(GenerateBuyer.newBuyer());
    }

    public static Optional<Buyer> notExist(){
        return Optional.empty();
    }
}
