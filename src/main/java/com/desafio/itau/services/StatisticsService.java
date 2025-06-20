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

    public StatisticsDTO getStats(){

        logger.info("Getting transaction stats...");
        DoubleSummaryStatistics stats = TransactionService.transactions.stream()
                .mapToDouble(TransactionDTO::getValor).summaryStatistics();

        return new StatisticsDTO(
                stats.getCount(),
                stats.getSum(),
                stats.getAverage(),
                stats.getMin(),
                stats.getMax()
        );
    }
}
