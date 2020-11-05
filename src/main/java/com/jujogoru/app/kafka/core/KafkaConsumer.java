package com.jujogoru.app.kafka.core;

import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class KafkaConsumer {
	private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "stock_market", groupId = "stock_market")
    public void consume(String ticker) throws IOException {
        logger.info(String.format("Consumer with ticker %s", ticker));
    }
}