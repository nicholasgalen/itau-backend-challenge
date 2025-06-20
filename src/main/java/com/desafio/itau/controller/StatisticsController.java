package com.desafio.itau.controller;

import com.desafio.itau.models.dto.StatisticsDTO;
import com.desafio.itau.services.StatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {

    @Autowired
    private StatisticsService service;

    static final private Logger logger = LoggerFactory.getLogger(StatisticsService.class);

    @GetMapping
    public StatisticsDTO getStatistics(){

        logger.info("Stats request recieved.");
        return service.getStats();
    }
}
