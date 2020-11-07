package com.jujogoru.app.kafka.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jujogoru.app.kafka.core.KafkaProducer;
import com.jujogoru.app.kafka.models.Alarm;

@RestController
@RequestMapping(value = "/notifications")
public class KafkaController {

    private final KafkaProducer producer;

    @Autowired
    KafkaController(KafkaProducer producer) {
        this.producer = producer;
    }
    
    @Bean
    public RestTemplate restTemplateController() {
        return new RestTemplate();
    }
    
    @Autowired
	private RestTemplate restTemplateController;
	
    @GetMapping(value = "/jujoKafka")
    public ResponseEntity<?> getTest() {

		Map<String, String> json = new HashMap<>();
		String response = restTemplateController.getForObject("http://localhost:8089/api/v1/jujo", String.class);
		json.put("response", response);
		
		return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
	}
    
    @GetMapping("/alarmsKafka")
    public ResponseEntity<List<Alarm>> getAllAlarms(@RequestParam(required = false) String user) {		
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("user", user);
		
		String queryParam = user != null ? "?user={user}" : ""; 
		
    	List<Alarm> alarmsList = Arrays.asList(restTemplateController
    			.getForObject("http://localhost:8089/api/v1/alarms"
    					.concat(queryParam), Alarm[].class, pathVariables));
		
		return new ResponseEntity<>(alarmsList, HttpStatus.OK);
	}
    
    @PostMapping(value = "/tickers")
    public void sendMessageToKafkaTopic(@RequestParam("ticker") String ticker) {
        this
        .producer
        .sendMessage(ticker);
    }
}
