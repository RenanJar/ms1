package com.recap.ms1.controller;

import com.recap.ms1.dto.IcmsRequest;
import com.recap.ms1.service.CalculadoraImposto;
import com.recap.ms1.service.Icms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ControllerTest {

    private MockMvc mockMvc;

    @Mock
    private Icms calculadoraImposto;

    @InjectMocks
    private Controller controller;

    @BeforeEach
    void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void deveRetornarStatus200() throws Exception {
        doReturn(BigDecimal.valueOf(100.0)).when(calculadoraImposto).calcular(BigDecimal.valueOf(100.0));

        String jsonRequest = "{\"valor\": 100.0}";

        mockMvc.perform(MockMvcRequestBuilders.post("/rest/v1/calculate/icms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk());
    }

    @Test
    void deveRetornarStatus200quandoChamarMetodoGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rest/v1"))
                .andExpect(status().isOk());
    }
}