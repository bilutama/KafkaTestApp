package com.example.kafkatest.Controller;

import com.example.kafkatest.Model.User;
import com.example.kafkatest.Producer.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
	@Autowired
	private final KafkaProducerService kafkaProducerService;

	public KafkaController(KafkaProducerService kafkaProducerService) {
		this.kafkaProducerService = kafkaProducerService;
	}

	@PostMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestBody User user){
		kafkaProducerService.send(user);
		return ResponseEntity.ok("Message sent to kafka topic");
	}
}
