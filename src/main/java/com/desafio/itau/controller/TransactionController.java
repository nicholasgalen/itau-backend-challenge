package com.desafio.itau.controller;

import com.desafio.itau.models.dto.TransactionDTO;
import com.desafio.itau.services.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {
    @Autowired
    private TransactionService service;

    @PostMapping("/transacao")
    public ResponseEntity<?> createTransaction(@RequestBody @Valid TransactionDTO transacao){

        service.create(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
