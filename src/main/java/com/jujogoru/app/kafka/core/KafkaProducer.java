package com.jujogoru.app.kafka.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
	
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    private static final String TOPIC = "stock_market";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String ticker) {
        logger.info(String.format("Producer with ticker %s", ticker));
        
        this
        .kafkaTemplate
        .send(TOPIC, ticker);
    }
}