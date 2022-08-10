package meli.dh.com.finalmeliproject.controller;

import meli.dh.com.finalmeliproject.dto.ProductDTO;
import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class ProductController {

    @Autowired
    private IProductService productService;

    /***
     * Retorna todos os produtos
     * @param buyerId id do cliente que buscando
     * @return todos os produtos disponíveis
     */
    @GetMapping
    public ResponseEntity<List<Product>> findProductsList(@RequestParam long buyerId){
        return new ResponseEntity<>(productService.findAll(buyerId), HttpStatus.OK);
    }

    @GetMapping("/check-stock/{id}")
    public ResponseEntity<Integer> checkStock(@PathVariable String id,@RequestParam long buyerId){
        ProductDTO dto = productService.checkStock(id,buyerId);
        return new ResponseEntity<>(dto.getQuantity(),HttpStatus.OK);
    }
}
