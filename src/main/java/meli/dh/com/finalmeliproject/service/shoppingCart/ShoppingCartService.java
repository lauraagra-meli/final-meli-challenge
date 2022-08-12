package meli.dh.com.finalmeliproject.service.shoppingCart;

import meli.dh.com.finalmeliproject.dto.shoppingCart.ProductPurchaseOrderDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.PurchaseOrderDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.ResponseShoppingCartDto;
import meli.dh.com.finalmeliproject.exception.BadRequestExceptionImp;
import meli.dh.com.finalmeliproject.model.Buyer;
import meli.dh.com.finalmeliproject.model.ProductShoppingCart;
import meli.dh.com.finalmeliproject.model.ShoppingCart;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;
import meli.dh.com.finalmeliproject.repository.IProductShoppingCartRepo;
import meli.dh.com.finalmeliproject.repository.IShoppingCartRepo;
import meli.dh.com.finalmeliproject.service.buyer.IBuyerService;
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
    private IShoppingCartRepo shoppingCartRepo;

    @Autowired
    private IProductShoppingCartRepo productShoppingCartRepo;

    @Autowired
    private IBuyerService buyerService;

    @Override
    public ResponseShoppingCartDto shoppingCart(PurchaseOrderDto orderDto) {
        ResponseShoppingCartDto responseShoppingCartDto = new ResponseShoppingCartDto();
        double totalPrice = 0;

        ShoppingCart shoppingCart = currentShoppingCart(orderDto.getShoopingCartId(), orderDto.getBuyerId());
        List<ProductShoppingCart> productShoppingCarts = new ArrayList<>();

        List<WareHouseProduct> wareHouseProducts = new ArrayList<>();

        //Trata todos os produtos que foi estão na lista de do carrinho de compra
        for (ProductPurchaseOrderDto p : orderDto.getProducts()) {
            ProductShoppingCart productShoopingCart = new ProductShoppingCart();

            //verifica se tem o produto em estoque disponível
            WareHouseProduct wareHouseProduct = iProductService.findByProductId(p.getProductId());
            if (p.getQuantity() > wareHouseProduct.getQuantity()) {
                throw new BadRequestExceptionImp("Product quantity " + wareHouseProduct.getProduct().getName() + " is insufficient stock");
            }

            //atualiza o valor total do carrinho
            totalPrice += wareHouseProduct.getProduct().getPrice() * p.getQuantity();
            responseShoppingCartDto.setTotalPrice(totalPrice);

            //alimenta a lista que ira atualizar a quantidade dos produtos
            wareHouseProduct.setQuantity(wareHouseProduct.getQuantity() - p.getQuantity());
            wareHouseProducts.add(wareHouseProduct);

            //itera lista de "produtos de carrinho" e compras
            productShoopingCart.setProductQuantity(p.getQuantity());
            productShoopingCart.setProduct(wareHouseProduct.getProduct());
            productShoopingCart.setShoppingCart(shoppingCart);
            productShoppingCarts.add(productShoopingCart);

        }

        //atualiza a quantidade do produto no banco de dados
        for (WareHouseProduct wp : wareHouseProducts){
            iProductService.save(wp.getProduct());
        }

        shoppingCartRepo.save(shoppingCart);
        productShoppingCartRepo.saveAll(productShoppingCarts);

        return responseShoppingCartDto;
    }

    public ShoppingCart findShoppingCartProductsById(long id) {
        Optional<ShoppingCart> shoppingCart = shoppingCartRepo.findById(id);

        if (shoppingCart.isEmpty()) {
            throw new BadRequestExceptionImp("Shopping cart dont exist");
        }

        return shoppingCart.get();
    }

    private ShoppingCart findById(long id){
        Optional<ShoppingCart> sc = shoppingCartRepo.findById(id);
        if (sc.isPresent()){
            return sc.get();
        }
        throw new BadRequestExceptionImp("Not exist Shopping Cart with id: " + id);
    }

    private ShoppingCart currentShoppingCart(long shoppingCartId, long buyerId){
        ShoppingCart shoppingCart;

        if (shoppingCartId > 0) {
            return findById(shoppingCartId);
        }

        shoppingCart = new ShoppingCart();

        Buyer buyer = buyerService.findById(buyerId);
        shoppingCart.setBuyer(buyer);

        return shoppingCart;
    }

}
