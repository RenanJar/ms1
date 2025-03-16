package com.recap.ms1.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


class IcmsTest {

    private CalculadoraImposto calculadoraImposto;

    @BeforeEach
    void setup(){
        calculadoraImposto = new Icms();
    }

    @Test
    void deveEfetuarCalculoCorreto(){
        var valorExpected = BigDecimal.valueOf(180);
        var valor = BigDecimal.valueOf(1000);
        BigDecimal imposto =  calculadoraImposto.calcular(valor);

        assertNotNull(imposto);
        assertEquals(valorExpected, imposto);
    }

    @Test
    void deveLancarExcecaoQuandoValorIsNull(){
        var valor = BigDecimal.ZERO;

        assertThrows(RuntimeException.class, () -> calculadoraImposto.calcular(valor));
        assertThrows(RuntimeException.class, () -> calculadoraImposto.calcular(null));
    }

}