package meli.dh.com.finalmeliproject.service.shoppingCart;

import meli.dh.com.finalmeliproject.dto.shoppingCart.ProductPurchaseOrderDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.PurchaseOrderDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.ResponseShoppingCartDto;
import meli.dh.com.finalmeliproject.exception.BadRequestExceptionImp;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;
import meli.dh.com.finalmeliproject.repository.IProductRepo;
import meli.dh.com.finalmeliproject.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ShoppingCartService implements IShoppingCartService {

    @Autowired
    private IProductService iProductService;

    @Autowired
    private IProductRepo productRepo;


    @Override
    public ResponseShoppingCartDto shoppingCart(PurchaseOrderDto orderDto) {
        double totalPrice = 0;

        if (!buyerAuth(orderDto.getBuyerId())) {
            // disparar exceção quando não for autorizado
        }

        ResponseShoppingCartDto responseShoppingCartDto = new ResponseShoppingCartDto();
        List<WareHouseProduct> wareHouseProducts = new ArrayList<>();

        for (ProductPurchaseOrderDto p : orderDto.getProducts()) {
            WareHouseProduct wareHouseProduct = iProductService.findByProductId(p.getProductId());

            if (p.getQuantity() > wareHouseProduct.getQuantity()) {
                throw new BadRequestExceptionImp("Product quantity " + wareHouseProduct.getProduct().getName() + " is insufficient stock");
            }

            double currentPrice = wareHouseProduct.getProduct().getPrice() * p.getQuantity();
            responseShoppingCartDto.setTotalPrice(totalPrice += currentPrice);

            try {
                wareHouseProduct.getProduct().setQuantity(wareHouseProduct.getProduct().getQuantity() - p.getQuantity());
            } catch (Exception e) {
                throw new BadRequestExceptionImp("ERROOOOO");
            }

            productRepo.save(wareHouseProduct.getProduct());
            wareHouseProducts.add(wareHouseProduct);
        }

        return responseShoppingCartDto;
    }

    public List<PurchaseOrderDto> findAllShoppingCartProducts(long orderNumber) {
        return null;
    }

    private boolean buyerAuth(String buyerId) {

        return true;
    }
}
