package meli.dh.com.finalmeliproject.controller;

import meli.dh.com.finalmeliproject.dto.ResquestBatchDTO;
import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products/inboundorder")
public class ProductController {

    @Autowired
    private IProductService service;

    @PostMapping
    public ResponseEntity<Product> newProduct(@RequestBody ResquestBatchDTO resquest) {
        System.out.println(resquest);
        return null;
    }
}
