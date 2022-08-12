package meli.dh.com.finalmeliproject.service.shoppingCart;

import meli.dh.com.finalmeliproject.dto.shoppingCart.ProductPurchaseOrderDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.PurchaseOrderDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.ResponseShoppingCartDto;
import meli.dh.com.finalmeliproject.exception.BadRequestExceptionImp;
import meli.dh.com.finalmeliproject.model.ProductShoppingCart;
import meli.dh.com.finalmeliproject.model.ShoppingCart;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;
import meli.dh.com.finalmeliproject.repository.IProductRepo;
import meli.dh.com.finalmeliproject.repository.IProductShoppingCartRepo;
import meli.dh.com.finalmeliproject.repository.IShoppingCartRepo;
import meli.dh.com.finalmeliproject.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService implements IShoppingCartService {

    @Autowired
    private IProductService iProductService;

    @Autowired
    private IProductRepo productRepo;

    @Autowired
        private IShoppingCartRepo shoppingCartRepo;

    @Override
    public ResponseShoppingCartDto shoppingCart(PurchaseOrderDto orderDto) {
        double totalPrice = 0;

        ResponseShoppingCartDto responseShoppingCartDto = new ResponseShoppingCartDto();
        List<WareHouseProduct> wareHouseProducts = new ArrayList<>();

        for (ProductPurchaseOrderDto p : orderDto.getProducts()) {
            WareHouseProduct wareHouseProduct = iProductService.findByProductId(p.getProductId());

            if (p.getQuantity() > wareHouseProduct.getQuantity()) {
                throw new BadRequestExceptionImp("Product quantity " + wareHouseProduct.getProduct().getName() + " is insufficient stock");
            }

            double currentPrice = wareHouseProduct.getProduct().getPrice() * p.getQuantity();
            responseShoppingCartDto.setTotalPrice(totalPrice += currentPrice);
            wareHouseProduct.getProduct().setQuantity(wareHouseProduct.getProduct().getQuantity() - p.getQuantity());

            iProductService.save(wareHouseProduct.getProduct());
            wareHouseProducts.add(wareHouseProduct);
        }

        return responseShoppingCartDto;
    }

    public ShoppingCart findShoppingCartProductsById(long id) {
        Optional<ShoppingCart> shoppingCart = shoppingCartRepo.findById(id);

        if (shoppingCart.isEmpty()) {
            throw new BadRequestExceptionImp("Shopping cart dont exist");
        }

        return shoppingCart.get();
    }
}
