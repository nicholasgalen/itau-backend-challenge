package com.desafio.itau.services;

import com.desafio.itau.models.dto.TransactionDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class TransactionService {

    protected static final ArrayList<TransactionDTO> transactions = new ArrayList<>();

    public void create(TransactionDTO transacao){
        transactions.add(transacao);
    }

    public void delete(){
        transactions.clear();
    }

    @PostConstruct
    public void startTimer() {
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                cleanOldTransactions();
            }
        }, 0, 60_000);
    }

    public void cleanOldTransactions(){
        transactions.clear();
    }
}
