package meli.dh.com.finalmeliproject.controller;

import meli.dh.com.finalmeliproject.dto.shoppingCar.ResponseProductsDTO;
import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class ProductController {

    @Autowired
    private IProductService productService;

    /***
     * Retorna todos os produtos de um centro de distribuição
     * @param buyerId id do cliente que buscando
     * @return todos os produtos disponíveis
     */
    @GetMapping
    public ResponseEntity<List<Product>> findProductsList(@RequestParam long buyerId){
        return new ResponseEntity<>(productService.findAll(buyerId), HttpStatus.OK);
    }
}
