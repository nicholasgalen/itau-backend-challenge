package com.desafio.itau.controller;

import com.desafio.itau.models.dto.StatisticsDTO;
import com.desafio.itau.services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {

    @Autowired
    private StatisticsService service;

    @GetMapping
    public StatisticsDTO getStatistics(){
        return service.getStats();
    }
}
