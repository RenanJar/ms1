package com.recap.ms1.controller;

import com.recap.ms1.dto.IcmsRequest;
import com.recap.ms1.service.CalculadoraImposto;
import com.recap.ms1.service.Icms;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("rest/v1")
public class Controller {

    private Icms calculadoraImposto;

    @GetMapping
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("MS1", HttpStatus.OK);
    }

    @PostMapping("/calculate/icms")
    public ResponseEntity<BigDecimal> calcularICMS(@RequestBody IcmsRequest request) {
        return new ResponseEntity<>(calculadoraImposto.calcular(BigDecimal.valueOf(request.getValor())), HttpStatus.OK);
    }

}
