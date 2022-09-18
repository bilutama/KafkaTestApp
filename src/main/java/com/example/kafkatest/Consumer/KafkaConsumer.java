package com.example.kafkatest.Consumer;

import com.example.kafkatest.Constants.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(topics = AppConstants.TOPIC_NAME,
		groupId = AppConstants.GROUP_ID)
	public void consume(String message){
		LOGGER.info(String.format("Message received -> %s", message));
	}
}
