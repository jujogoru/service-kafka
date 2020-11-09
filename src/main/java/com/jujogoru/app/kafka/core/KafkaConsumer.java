package com.jujogoru.app.kafka.core;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jujogoru.app.kafka.models.TickerPrice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.annotation.KafkaListener;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class KafkaConsumer {
	private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	@Autowired
	private RestTemplate restTemplate;

    @KafkaListener(topics = "stock_market", groupId = "stock_market")
    public void consume(String ticker) throws IOException {
        logger.debug(String.format("Consumer with ticker %s", ticker));
        TickerPrice tickerPrice = new TickerPrice().setTickerPrice(ticker); 
        restTemplate.postForObject("http://localhost:8089/api/v1/alarms/stocks", tickerPrice,  HttpStatus.class);
    }
}