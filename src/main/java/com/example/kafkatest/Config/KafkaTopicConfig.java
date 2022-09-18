package com.example.kafkatest.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	public NewTopic getNewTopic(){
		return TopicBuilder.name("skarb_message").build();
	}
}
