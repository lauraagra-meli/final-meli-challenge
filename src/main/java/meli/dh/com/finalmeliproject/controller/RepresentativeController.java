package meli.dh.com.finalmeliproject.controller;

import meli.dh.com.finalmeliproject.model.Representative;
import meli.dh.com.finalmeliproject.service.representative.RepresentativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/representative")
public class RepresentativeController {

    @Autowired
    private RepresentativeService representativeService;

    @PostMapping
    public ResponseEntity<Representative> saveRepresentative(@RequestBody Representative representative){
        return ResponseEntity.status(HttpStatus.CREATED).body(representativeService.save(representative));
    }

}
