package meli.dh.com.finalmeliproject.service.shoppingCart;

import meli.dh.com.finalmeliproject.dto.shoppingCart.ProductPurchaseOrderDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.PurchaseOrderDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.ResponseShoppingCartDto;
import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;
import meli.dh.com.finalmeliproject.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService implements IShoppingCartService {

    @Autowired
    private IProductService iProductService;

    @Override
    public ResponseShoppingCartDto shoppingCart(PurchaseOrderDto dto) {

        if (!buyerAuth(dto.getBuyerId())) {
            //desparar exceção quando não for autorizado

        }

        ResponseShoppingCartDto responseShoppingCartDto = new ResponseShoppingCartDto();

        List<WareHouseProduct> products = new ArrayList<>();

        for (ProductPurchaseOrderDto p : dto.getProducts()) {

            WareHouseProduct wareHouseProduct = iProductService.findByProductId(p.getProductId());

            if (p.getQuantity() > wareHouseProduct.getQuantity()) {
                // quantidade não tem em estoque
            }

            products.add(wareHouseProduct);

            wareHouseProduct.setQuantity(wareHouseProduct.getQuantity() - p.getQuantity());


        }


        return responseShoppingCartDto;

    }

    private boolean buyerAuth(String buyerId) {

        return true;
    }

}
