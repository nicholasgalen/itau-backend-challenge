package com.desafio.itau.services;

import com.desafio.itau.models.dto.TransactionDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TransactionService {

    private final ArrayList<TransactionDTO> transactions = new ArrayList<>();

    public void create(TransactionDTO transacao){
        transactions.add(transacao);
    }

    public void delete(){
        transactions.clear();
    }
}
