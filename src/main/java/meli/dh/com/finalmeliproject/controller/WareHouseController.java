package meli.dh.com.finalmeliproject.controller;

import meli.dh.com.finalmeliproject.dto.WareHouseProductDTO;
import meli.dh.com.finalmeliproject.model.WareHouseProduct;
import meli.dh.com.finalmeliproject.service.wareHouse.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/fresh-products/warehouse")
public class WareHouseController {

    @Autowired
    WareHouseService service;

//    @GetMapping("/{id}")
//    public ResponseEntity<List<WareHouseProductDTO>> findAllProductsByWareHouse(@PathVariable String id) {
//        List<WareHouseProductDTO> wareHouseProductDTOList = service.findAllProductsByWareHouse(id);
//        return ResponseEntity.ok().body(wareHouseProductDTOList);
//    }
}
