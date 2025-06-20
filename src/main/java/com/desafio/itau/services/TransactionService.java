package com.desafio.itau.services;

import com.desafio.itau.controller.TransactionController;
import com.desafio.itau.models.dto.TransactionDTO;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class TransactionService {

    static final protected ArrayList<TransactionDTO> transactions = new ArrayList<>();

    static final private Logger logger = LoggerFactory.getLogger(TransactionService.class);

    public static void create(TransactionDTO transacao){

        logger.info("Add transaction method called.");
        transactions.add(transacao);
    }

    public void delete(){

        logger.info("Delete transaction method called.");
        transactions.clear();
    }

    @PostConstruct
    public void startTimer() {

        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logger.info("Timer ended.");
                cleanOldTransactions();
                logger.info("Timer started.");
            }
        }, 0, 60_000);
    }

    // Getters for tests
    public void cleanOldTransactions(){

        transactions.clear();
    }

    public static int getTransactionCount() {
        return transactions.size();
    }

    public static void clearTransactions() {
        transactions.clear();
    }

}
