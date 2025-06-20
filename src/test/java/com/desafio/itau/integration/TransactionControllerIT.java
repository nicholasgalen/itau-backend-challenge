package com.desafio.itau.integration;

import com.desafio.itau.models.dto.TransactionDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.OffsetDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test // Should return 201
    void testCreateTransaction() throws Exception {
        TransactionDTO transaction = new TransactionDTO();
        transaction.setValor(150.0);
        transaction.setDataHora(OffsetDateTime.now());

        String json = objectMapper.writeValueAsString(transaction);

        mockMvc.perform(post("/transacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    @Test // Should return 200
    void testDeleteTransactions() throws Exception {
        mockMvc.perform(delete("/transacao"))
                .andExpect(status().isOk());
    }

    @Test // Should return 422
    void testCreateTransaction_InvalidValue() throws Exception {
        TransactionDTO transaction = new TransactionDTO();
        transaction.setValor(-50.0);
        transaction.setDataHora(OffsetDateTime.now());

        String json = objectMapper.writeValueAsString(transaction);

        mockMvc.perform(post("/transacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test // Should return 400
    void testCreateTransaction_MalformedJson() throws Exception {
        String invalidJson = "{ \"valor\": 100.0, \"dataHora\": \"2023-05-01T10:00:00\" ";

        mockMvc.perform(post("/transacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidJson))
                .andExpect(status().isBadRequest());
    }
}
