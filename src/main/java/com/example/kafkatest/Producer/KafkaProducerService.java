package com.example.kafkatest.Producer;

import com.example.kafkatest.Constants.AppConstants;
import com.example.kafkatest.Model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

	@Autowired
	private KafkaTemplate<Long, User> kafkaTemplate;

	public void send(User user) {
		LOGGER.info("Sending User Json Serializer : {}", user);
		kafkaTemplate.send(AppConstants.TOPIC_NAME, user.getId(), user);
	}
}
