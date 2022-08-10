package meli.dh.com.finalmeliproject.service.shoppingCart;

import meli.dh.com.finalmeliproject.model.ShoppingCart;
import meli.dh.com.finalmeliproject.model.PurchaseOrder;
import meli.dh.com.finalmeliproject.repository.IshoppingCartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ShoppingCartService implements IShoppingCartService {

    @Autowired
    private IshoppingCartRepo repo;



    public PurchaseOrder purchaseOrder (ShoppingCart cart,long buyerId) {

        List<ShoppingCart> purchaseOrders = cart.getPurchaseOrder().getShoppingCart();

        List<ShoppingCart> shoppingCartItems = new ArrayList<>();



        return null;
    }
}
