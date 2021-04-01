package com.rimsan.springboot.kafka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class kafkaConfiguration {
	

	@Value("${kafka.topic}")
	String kafkaTopic;

	@Value("${kafka.bootstrap.servers}")
	String kafkaBootstrapServers;
	
	@Value("${kafka.consumer.concurrent.worker.count}")
	int messageConsumerConcurrentWorkerCount;

	@Value("${kafka.poll.timeout.millis}")
	int messagePollTimeoutInMillis;
	
	@Value("${spring.kafka.consumer.group-id}")
	String consumerGroupId;
	
	

	public String getKafkaTopic() {
		return kafkaTopic;
	}

	public void setKafkaTopic(String kafkaTopic) {
		this.kafkaTopic = kafkaTopic;
	}

	public String getKafkaBootstrapServers() {
		return kafkaBootstrapServers;
	}

	public void setKafkaBootstrapServers(String kafkaBootstrapServers) {
		this.kafkaBootstrapServers = kafkaBootstrapServers;
	}

	public int getMessageConsumerConcurrentWorkerCount() {
		return messageConsumerConcurrentWorkerCount;
	}

	public void setMessageConsumerConcurrentWorkerCount(int messageConsumerConcurrentWorkerCount) {
		this.messageConsumerConcurrentWorkerCount = messageConsumerConcurrentWorkerCount;
	}

	public int getMessagePollTimeoutInMillis() {
		return messagePollTimeoutInMillis;
	}

	public void setMessagePollTimeoutInMillis(int messagePollTimeoutInMillis) {
		this.messagePollTimeoutInMillis = messagePollTimeoutInMillis;
	}

	public String getConsumerGroupId() {
		return consumerGroupId;
	}

	public void setConsumerGroupId(String consumerGroupId) {
		this.consumerGroupId = consumerGroupId;
	}
	
	
}
