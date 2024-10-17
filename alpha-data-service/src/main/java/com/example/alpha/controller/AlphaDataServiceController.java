package com.example.alpha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.alpha.service.AlphaDataService;
import com.example.alpha.service.KafkaLoggingService;

@RestController
@RequestMapping("/api")
public class AlphaDataServiceController {
	
	private static final Logger logger = LoggerFactory.getLogger(AlphaDataServiceController.class);
	
	@Autowired
    private AlphaDataService alphaDataService;
	
	@Autowired
    private KafkaLoggingService kafkaLoggingService;

	
	@GetMapping("/greet")
    public ResponseEntity<String> greet() {
		String logMessage = "Controller: Handling /greet endpoint";
        kafkaLoggingService.sendLogToKafka(logMessage);
        logger.info(logMessage);
        return ResponseEntity.ok(alphaDataService.getData());
    }

}
