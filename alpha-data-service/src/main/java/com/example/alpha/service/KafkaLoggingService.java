package com.example.alpha.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaLoggingService {
	private static final Logger logger = LoggerFactory.getLogger(KafkaLoggingService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "alpha-topic";

    public void sendLogToKafka(String logMessage) {
        kafkaTemplate.send(TOPIC, logMessage);
        logger.info("Log message sent to Kafka: {}", logMessage);
    }

}
