package com.desafio.itau.services;

import com.desafio.itau.models.dto.StatisticsDTO;
import com.desafio.itau.models.dto.TransactionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;

@Service
public class StatisticsService{

    static final private Logger logger = LoggerFactory.getLogger(StatisticsService.class);

    public StatisticsDTO getStats() {
        logger.info("Getting transaction stats...");
        DoubleSummaryStatistics stats = TransactionService.transactions.stream()
                .mapToDouble(TransactionDTO::getValor)
                .summaryStatistics();

        long count = stats.getCount();
        double sum = stats.getSum();
        double avg = count == 0 ? 0 : stats.getAverage();
        double min = count == 0 ? 0 : stats.getMin();
        double max = count == 0 ? 0 : stats.getMax();

        return new StatisticsDTO(
                count,
                sum,
                avg,
                min,
                max
        );
    }
}
