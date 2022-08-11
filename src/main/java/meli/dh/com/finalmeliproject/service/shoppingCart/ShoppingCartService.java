package meli.dh.com.finalmeliproject.service.shoppingCart;

import meli.dh.com.finalmeliproject.dto.shoppingCart.PurchaseOrderDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.ResponseShoppingCartDto;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService implements IShoppingCartService {

    @Override
    public ResponseShoppingCartDto shoppingCart(PurchaseOrderDto dto){

        if(!buyerAuth(dto.getBuyerId())){
            //desparar exceção quando não for autorizado

        }

        ResponseShoppingCartDto responseShoppingCartDto = new ResponseShoppingCartDto();



        return responseShoppingCartDto;

    }

    private boolean buyerAuth(String buyerId) {

        return true;
    }

}
