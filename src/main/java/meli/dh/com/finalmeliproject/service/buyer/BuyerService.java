package meli.dh.com.finalmeliproject.service.buyer;

import meli.dh.com.finalmeliproject.model.Buyer;
import meli.dh.com.finalmeliproject.repository.IBuyerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerService implements IBuyerService{

    @Autowired
    private IBuyerRepo buyerRepo;

    @Override
    public Buyer findById(long id) {
        return buyerRepo.findById(id).get();
    }

    @Override
    public boolean buyerExist(long id) {
        return buyerRepo.findById(id).isPresent();
    }
}
