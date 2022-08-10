package meli.dh.com.finalmeliproject.service.buyer;

import meli.dh.com.finalmeliproject.model.Buyer;

public interface IBuyerService {
    Buyer findById(long id);
    boolean buyerExist(long id);
}
