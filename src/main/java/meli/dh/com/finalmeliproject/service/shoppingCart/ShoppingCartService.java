package meli.dh.com.finalmeliproject.service.shoppingCart;

import meli.dh.com.finalmeliproject.dto.shoppingCart.ProductPurchaseOrderDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.PurchaseOrderDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.ResponseShoppingCartDto;
import meli.dh.com.finalmeliproject.exception.BadRequestExceptionImp;
import meli.dh.com.finalmeliproject.model.*;
import meli.dh.com.finalmeliproject.model.enums.OrderStatus;
import meli.dh.com.finalmeliproject.repository.IProductShoppingCartRepo;
import meli.dh.com.finalmeliproject.repository.IPurchaseOrderRepo;
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
    private IPurchaseOrderRepo purchaseOrderRepo;

    @Autowired
    private IBuyerService buyerService;

    @Override
    public ResponseShoppingCartDto shoppingCart(PurchaseOrderDto orderDto) {
        ResponseShoppingCartDto responseShoppingCartDto = new ResponseShoppingCartDto();
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        double totalPrice = 0;

        ShoppingCart shoppingCart = currentShoppingCart(orderDto.getShoopingCartId(), orderDto.getBuyerId());
        List<ProductShoppingCart> productShoppingCarts = new ArrayList<>();

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

            //itera lista de "produtos de carrinho" e compras
            productShoopingCart.setProductQuantity(p.getQuantity());
            productShoopingCart.setProduct(wareHouseProduct.getProduct());
            productShoopingCart.setShoppingCart(shoppingCart);
            productShoppingCarts.add(productShoopingCart);
        }

        // define o status do carrinho como aberto até finalizar a compra e o adiciona à purchase order
        purchaseOrder.setStatusOrder(OrderStatus.OPENED);
        purchaseOrder.setShoppingCart(shoppingCart);
        purchaseOrderRepo.save(purchaseOrder);

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

    public PurchaseOrder editShoppingCart(long orderId) {
        Optional<PurchaseOrder> purchaseOrder = purchaseOrderRepo.findById(orderId);

        if (purchaseOrder.isEmpty()) {
            throw new BadRequestExceptionImp("Purchase Order dont exist");
        }
        if (purchaseOrder.get().getStatusOrder() == OrderStatus.CLOSED) {
            throw new BadRequestExceptionImp("Purchase Order Status is already closed");
        }

        purchaseOrder.get().setStatusOrder(OrderStatus.CLOSED);

        List<ProductShoppingCart> products = purchaseOrder.get().getShoppingCart().getListOfShoppingProducts();

        //atualiza a quantidade do produto no banco de dados
        for (ProductShoppingCart product : products) {
            WareHouseProduct wareHouseProduct = iProductService.findByProductId(product.getProduct().getId());

            // validar se o produto ainda possui estoque
            if (product.getProductQuantity() > wareHouseProduct.getQuantity()) {
                throw new BadRequestExceptionImp("Product quantity " + wareHouseProduct.getProduct().getName() + " is insufficient stock");
            }

            wareHouseProduct.setQuantity((int) (wareHouseProduct.getQuantity() - product.getProductQuantity()));
        }

        return purchaseOrderRepo.save(purchaseOrder.get());
    }

    private ShoppingCart currentShoppingCart(long shoppingCartId, long buyerId) {
        ShoppingCart shoppingCart;

        if (shoppingCartId > 0) {
            return findShoppingCartProductsById(shoppingCartId);
        }

        shoppingCart = new ShoppingCart();

        Buyer buyer = buyerService.findById(buyerId);
        shoppingCart.setBuyer(buyer);

        return shoppingCart;
    }

}
