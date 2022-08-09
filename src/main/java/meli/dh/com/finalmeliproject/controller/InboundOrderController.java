package meli.dh.com.finalmeliproject.controller;

import meli.dh.com.finalmeliproject.dto.ResponseDTO;
import meli.dh.com.finalmeliproject.dto.ResquestInboundOrderDTO;
import meli.dh.com.finalmeliproject.service.inbound.IInboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class InboundOrderController {

    @Autowired
    private IInboundService service;

    /***
     * Salvar um novo lote de produtos em um armazem
     * @param resquest informações contendo os produtos do lote
     * @param representativeId quem esta adicionando um lote de produto
     * @return o lote salvo
     */
    @PostMapping("/inboundorder")
    public ResponseEntity<ResponseDTO> saveInboundOrder(@RequestBody ResquestInboundOrderDTO resquest, @RequestParam long representativeId) {
        return new ResponseEntity<>(service.save(resquest.getInboundOrder(), representativeId), HttpStatus.CREATED);
    }

    /***
     * Adiciona novos produtos em lote já salvo
     * @param resquest informações contendo os produtos do lote
     * @param representativeId quem esta adicionando um lote de produto
     * @return produtos salvos no lote
     */
    @PutMapping("/inboundorder")
    public ResponseEntity<ResponseDTO> updateInboundOrder(@RequestBody ResquestInboundOrderDTO resquest, @RequestParam long representativeId) {
        return new ResponseEntity<>(service.update(resquest.getInboundOrder(), representativeId), HttpStatus.CREATED);
    }
}
