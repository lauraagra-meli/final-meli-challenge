package meli.dh.com.finalmeliproject.controller;

import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fresh-products/inboundorder/")
public class ProductController {

    @Autowired
    private IProductService service;

    @GetMapping
    public ResponseEntity<Product> newProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
    }
}
