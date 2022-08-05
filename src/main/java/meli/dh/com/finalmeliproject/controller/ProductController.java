package meli.dh.com.finalmeliproject.controller;

import meli.dh.com.finalmeliproject.dto.BatchDTO;
import meli.dh.com.finalmeliproject.dto.ResquestInboundOrderDTO;
import meli.dh.com.finalmeliproject.service.Inbound.IInboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/inboundorder")
public class ProductController {

    @Autowired
    private IInboundService service;

    @PostMapping
    public ResponseEntity<List<BatchDTO>> saveInboundOrder(@RequestBody ResquestInboundOrderDTO resquest) {
        return new ResponseEntity<>(service.save(resquest.getInboundOrder()), HttpStatus.ACCEPTED);
    }
}
