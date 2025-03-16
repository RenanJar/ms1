package com.recap.ms1.controller;

import com.recap.ms1.service.CalculadoraImposto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("rest/v1")
public class Controller {

    private CalculadoraImposto calculadoraImposto;

    @GetMapping
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("MS1", HttpStatus.OK);
    }

    @GetMapping("/calculate/icms")
    public ResponseEntity<BigDecimal> calcularICMS(BigDecimal valorICms) {
        return new ResponseEntity<>(calculadoraImposto.calcular(valorICms), HttpStatus.OK);
    }

}
