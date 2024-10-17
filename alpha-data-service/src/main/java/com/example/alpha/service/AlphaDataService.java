package com.example.alpha.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alpha.dao.AlphaDataServiceDao;

@Service
public class AlphaDataService {
	private static final Logger logger = LoggerFactory.getLogger(AlphaDataService.class);
	
	@Autowired
    private AlphaDataServiceDao alphaDataServiceDao;

	@Autowired
    private KafkaLoggingService kafkaLoggingService;
	
	public String getData() {
		String logMessage = "Service: Fetching data from DAO";
        kafkaLoggingService.sendLogToKafka(logMessage);
        logger.info(logMessage);
        return alphaDataServiceDao.fetchData();
    }
}
