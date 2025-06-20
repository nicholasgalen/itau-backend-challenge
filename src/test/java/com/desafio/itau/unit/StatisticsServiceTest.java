package com.desafio.itau.unit;

import com.desafio.itau.models.dto.StatisticsDTO;
import com.desafio.itau.models.dto.TransactionDTO;
import com.desafio.itau.services.StatisticsService;
import com.desafio.itau.services.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsServiceTest {

    private StatisticsService statisticsService;

    @BeforeEach
    void setUp() {
        statisticsService = new StatisticsService();
        TransactionService.clearTransactions();
    }

    @Test
    void testGetStatsEmptyTransactions() {
        StatisticsDTO stats = statisticsService.getStats();

        assertEquals(0, stats.getCount());
        assertEquals(0, stats.getSum());
        assertEquals(0, stats.getAvg());
        assertEquals(0, stats.getMin());
        assertEquals(0, stats.getMax());
    }

    @Test
    void testGetStatsWithTransactions() {
        TransactionDTO t1 = new TransactionDTO();
        t1.setValor(10.0);
        t1.setDataHora(OffsetDateTime.now());

        TransactionDTO t2 = new TransactionDTO();
        t2.setValor(20.0);
        t2.setDataHora(OffsetDateTime.now());

        TransactionService.create(t1);
        TransactionService.create(t2);

        StatisticsDTO stats = statisticsService.getStats();

        assertEquals(2, stats.getCount());
        assertEquals(30.0, stats.getSum());
        assertEquals(15.0, stats.getAvg());
        assertEquals(10.0, stats.getMin());
        assertEquals(20.0, stats.getMax());
    }
}
