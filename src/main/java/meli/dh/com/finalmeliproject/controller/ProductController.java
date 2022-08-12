package meli.dh.com.finalmeliproject.controller;

import com.sun.istack.Nullable;
import meli.dh.com.finalmeliproject.dto.shoppingCart.PurchaseOrderDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.RequestShoppingCartDto;
import meli.dh.com.finalmeliproject.dto.shoppingCart.ResponseShoppingCartDto;
import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.model.ProductShoppingCart;
import meli.dh.com.finalmeliproject.model.ShoppingCart;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;
import meli.dh.com.finalmeliproject.service.product.IProductService;
import meli.dh.com.finalmeliproject.service.product.ProductService;
import meli.dh.com.finalmeliproject.service.shoppingCart.IShoppingCartService;
import meli.dh.com.finalmeliproject.service.shoppingCart.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IShoppingCartService iShoppingCartService;

    @Autowired
    private ProductService service;

    /***
     * Retorna todos os produtos
     * @return todos os produtos disponíveis
     */
    @GetMapping
    public ResponseEntity<List<Product>> findProductsList(){
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/check-stock/{id}")
    public ResponseEntity<Integer> checkStock(@PathVariable String id){
        return new ResponseEntity<>(productService.checkStock(id).getQuantity(),HttpStatus.OK);
    }

    @GetMapping("/by-category")
    public ResponseEntity<List<Product>> listingProductsByCategory (@RequestParam @Nullable String category){
        List<Product> productsByCategory = productService.findProductsByCategory(category);
        return ResponseEntity.ok().body(productsByCategory);
    }

    @PostMapping("orders/by-shopping-cart")
    public ResponseEntity<ResponseShoppingCartDto> shoppingCart(@RequestBody RequestShoppingCartDto request){
        return new ResponseEntity<>(iShoppingCartService.shoppingCart(request.getPurchaseOrder()),
                HttpStatus.CREATED);
    }

    @GetMapping("orders/{id}")
    public ResponseEntity<ShoppingCart> findAllShoppingCartProducts(@PathVariable long id) {
        return ResponseEntity.ok().body(iShoppingCartService.findShoppingCartProductsById(id));
    }
}
