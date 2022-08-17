package meli.dh.com.finalmeliproject.controller;


import meli.dh.com.finalmeliproject.dto.WareHouseDTO;
import meli.dh.com.finalmeliproject.service.wareHouse.IWareHouseService;
import meli.dh.com.finalmeliproject.service.wareHouse.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/warehouse")
public class WareHouseController {

    @Autowired
    IWareHouseService service;

    @GetMapping("/{id}")
    public ResponseEntity<List<WareHouseDTO>> allProductsByWareHouse(@PathVariable String id) {
        return ResponseEntity.ok().body(service.findAllProductsByWareHouse(id));
    }
}
