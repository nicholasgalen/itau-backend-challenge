package com.desafio.itau.controller;

import com.desafio.itau.models.dto.TransactionDTO;
import com.desafio.itau.services.TransactionService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransactionController {
    @Autowired
    private TransactionService service;

    static final private Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @PostMapping
    public ResponseEntity<?> createTransaction(@RequestBody @Valid TransactionDTO transacao){

        logger.info("Request recieved on amount of: {}", transacao.getValor());
        service.create(transacao);
        logger.info("Transaction created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public void delete(){

        logger.info("Deleted all transactions.");
        service.delete();
    }
}
