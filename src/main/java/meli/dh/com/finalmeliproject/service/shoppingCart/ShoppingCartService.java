package meli.dh.com.finalmeliproject.service.shoppingCart;

import meli.dh.com.finalmeliproject.dto.shoppingCart.ProductPurchaseOrderDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.PurchaseOrderDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.ResponseShoppingCartDto;
import meli.dh.com.finalmeliproject.exception.BadRequestExceptionImp;
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
        double totalPrice = 0;

        if (!buyerAuth(dto.getBuyerId())) {
            // disparar exceção quando não for autorizado
        }

        ResponseShoppingCartDto responseShoppingCartDto = new ResponseShoppingCartDto();
        List<WareHouseProduct> wareHouseProducts = new ArrayList<>();

        for (ProductPurchaseOrderDto p : dto.getProducts()) {
            WareHouseProduct wareHouseProduct = iProductService.findByProductId(p.getProductId());

            if (p.getQuantity() > wareHouseProduct.getQuantity()) {
                throw new BadRequestExceptionImp("Product quantity " + wareHouseProduct.getProduct().getName() + " is insufficient stock");
            }

            double currentPrice = wareHouseProduct.getProduct().getPrice() * p.getQuantity();
            responseShoppingCartDto.setTotalPrice(totalPrice += currentPrice);
            wareHouseProducts.add(wareHouseProduct);
            wareHouseProduct.getProduct().setQuantity(p.getQuantity() - wareHouseProduct.getProduct().getQuantity());
            int result = wareHouseProduct.getProduct().getQuantity() - p.getQuantity();
            wareHouseProduct.getProduct().setQuantity(result);
            System.out.println("-------------------------------------"+ result);
        }

        return responseShoppingCartDto;
    }

    private boolean buyerAuth(String buyerId) {

        return true;
    }
}
