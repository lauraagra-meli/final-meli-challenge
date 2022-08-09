package meli.dh.com.finalmeliproject.controller;

import meli.dh.com.finalmeliproject.dto.ResponseDTO;
import meli.dh.com.finalmeliproject.dto.RequestInboundOrderDTO;
import meli.dh.com.finalmeliproject.service.inbound.IInboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products/inboundorder")
public class InboundOrderController {

    @Autowired
    private IInboundService service;

    @PostMapping
    public ResponseEntity<ResponseDTO> saveInboundOrder(@RequestBody RequestInboundOrderDTO request, @RequestParam long representativeId) {
        return new ResponseEntity<>(service.save(request.getInboundOrder(), representativeId), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ResponseDTO> updateInboundOrder(@RequestBody RequestInboundOrderDTO request, @RequestParam long representativeId) {
        return new ResponseEntity<>(service.update(request.getInboundOrder(), representativeId), HttpStatus.CREATED);
    }
}
