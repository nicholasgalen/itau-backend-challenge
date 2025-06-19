package com.desafio.itau.services;

import com.desafio.itau.models.dto.TransactionDTO;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    public TransactionDTO create(TransactionDTO transacao){
        return transacao;
    }
}
