package com.desafio.itau.unit;

import com.desafio.itau.models.dto.TransactionDTO;
import com.desafio.itau.services.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    private TransactionService service;

    @BeforeEach
    void setUp() {
        service = new TransactionService();
        TransactionService.clearTransactions();
    }

    @Test
    void testCreateTransactionAddsToList() {
        TransactionDTO dto = new TransactionDTO();
        dto.setValor(100.0);
        dto.setDataHora(OffsetDateTime.now());

        service.create(dto);

        assertEquals(1, TransactionService.getTransactionCount());
    }

    @Test
    void testDeleteRemovesAllTransactions() {
        TransactionDTO dto = new TransactionDTO();
        dto.setValor(100.0);
        dto.setDataHora(OffsetDateTime.now());

        service.create(dto);
        assertEquals(1, TransactionService.getTransactionCount());

        service.delete();

        assertEquals(0, TransactionService.getTransactionCount());
    }

    @Test
    void testCleanOldTransactionsClearsList() {
        TransactionDTO dto1 = new TransactionDTO();
        dto1.setValor(200.0);
        dto1.setDataHora(OffsetDateTime.now());

        service.create(dto1);
        assertEquals(1, TransactionService.getTransactionCount());

        service.cleanOldTransactions();

        assertEquals(0, TransactionService.getTransactionCount());
    }
}
