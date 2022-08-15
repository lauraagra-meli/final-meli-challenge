package meli.dh.com.finalmeliproject.controller;

import meli.dh.com.finalmeliproject.dto.BatchDTO;
import meli.dh.com.finalmeliproject.model.Batch;
import meli.dh.com.finalmeliproject.service.wareHouseProductService.IWareHouseProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class WareHouseProductController {

    @Autowired
    private IWareHouseProductService wareHouseProductService;

    @GetMapping("/{id}")
    public ResponseEntity<List<BatchDTO>> allProductsInWarehouses(@PathVariable String id){
        List<BatchDTO> allProducts = wareHouseProductService.allProducts(id);
        return ResponseEntity.ok().body(allProducts);
    }
}
