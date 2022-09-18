package com.example.kafkatest.Controller;

import com.example.kafkatest.Producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {

	private final KafkaProducer kafkaProducer;

	public KafkaController(KafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}

	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message){
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent to kafka topic");
	}
}
