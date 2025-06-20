package com.desafio.itau.integration;

import com.desafio.itau.models.dto.TransactionDTO;
import com.desafio.itau.services.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.OffsetDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StatisticsControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        TransactionService.clearTransactions();
    }

    @Test // Should return 200
    public void testGetStatisticsEmpty() throws Exception {
        mockMvc.perform(get("/estatistica")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count").value(0))
                .andExpect(jsonPath("$.sum").value(0.0))
                .andExpect(jsonPath("$.avg").value(0.0))
                .andExpect(jsonPath("$.min").value(0.0))
                .andExpect(jsonPath("$.max").value(0.0));
    }

    @Test // Should return 200
    public void testGetStatisticsWithTransactions() throws Exception {
        TransactionDTO t1 = new TransactionDTO();
        t1.setValor(10.0);
        t1.setDataHora(OffsetDateTime.now());
        TransactionService.create(t1);

        TransactionDTO t2 = new TransactionDTO();
        t2.setValor(20.0);
        t2.setDataHora(OffsetDateTime.now());
        TransactionService.create(t2);

        mockMvc.perform(get("/estatistica")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count").value(2))
                .andExpect(jsonPath("$.sum").value(30.0))
                .andExpect(jsonPath("$.avg").value(15.0))
                .andExpect(jsonPath("$.min").value(10.0))
                .andExpect(jsonPath("$.max").value(20.0));
    }
}
