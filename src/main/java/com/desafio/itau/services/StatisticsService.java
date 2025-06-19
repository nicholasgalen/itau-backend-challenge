package com.desafio.itau.services;

import com.desafio.itau.models.dto.StatisticsDTO;
import com.desafio.itau.models.dto.TransactionDTO;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;

@Service
public class StatisticsService{

    public StatisticsDTO getStats(){
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
