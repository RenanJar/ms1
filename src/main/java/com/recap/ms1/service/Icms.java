package com.recap.ms1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@AllArgsConstructor
public class Icms implements CalculadoraImposto {

    private final BigDecimal aliquota = new BigDecimal("18");

    @Override
    public BigDecimal calcular(BigDecimal valor) {
        isValid(valor);
        valor = valor.setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal byCem = BigDecimal.valueOf(100).setScale(2, RoundingMode.HALF_UP);
        return valor.multiply(aliquota).divide(byCem);
    }


    private boolean isValid(BigDecimal valor) {
        boolean result = true;

        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Valor invalido");
        }

        return result;
    }

}
