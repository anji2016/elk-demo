package com.example.alpha.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.alpha.service.KafkaLoggingService;

@Repository
public class AlphaDataServiceDao {
	
	private static final Logger logger = LoggerFactory.getLogger(AlphaDataServiceDao.class);
	
	@Autowired
    private KafkaLoggingService kafkaLoggingService;

    public String fetchData() {
    	String logMessage = "DAO: Querying database for data";
        kafkaLoggingService.sendLogToKafka(logMessage);
        logger.info(logMessage);
        return "Some data from database of Alpha Data Service";
    }

}
