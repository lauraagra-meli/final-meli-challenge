package meli.dh.com.finalmeliproject.controller;

import meli.dh.com.finalmeliproject.dto.shoppingCart.RequestShoppingCartDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.ResponseShoppingCartDto;
import meli.dh.com.finalmeliproject.model.ProductShoppingCart;
import meli.dh.com.finalmeliproject.model.PurchaseOrder;
import meli.dh.com.finalmeliproject.model.ShoppingCart;
import meli.dh.com.finalmeliproject.service.product.IProductService;
import meli.dh.com.finalmeliproject.service.shoppingCart.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class ShoppingCartController {

    @Autowired
    private IShoppingCartService service;

    @PostMapping("/orders")
    public ResponseEntity<ResponseShoppingCartDto> shoppingCart(@RequestBody RequestShoppingCartDto request){
        return new ResponseEntity<>(service.shoppingCart(request.getPurchaseOrder()),
                HttpStatus.CREATED);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<ShoppingCart> findAllShoppingCartProducts(@PathVariable long id) {
        return ResponseEntity.ok().body(service.findShoppingCartProductsById(id));
    }

    @PutMapping("/orders")
    public ResponseEntity<PurchaseOrder> editPurchaseOrderStatus(@RequestParam long orderId) {
        return new ResponseEntity<>(service.editPurchaseOrderStatus(orderId),
                HttpStatus.CREATED);
    }

    @PatchMapping("/orders/{id}")
    public ResponseEntity<ProductShoppingCart> updateProductQuantityShoppingCart(@PathVariable long id, @RequestBody Map<String, Long> changes) {
        return new ResponseEntity<>(service.updateProductQuantityShoppingCart(id, changes), HttpStatus.CREATED);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Void> deleteProductShoppingCart(@PathVariable long id) {
        service.deleteProductShoppingCart(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
