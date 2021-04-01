package com.rimsan.springboot.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;


@EnableKafka
@Configuration
public class KafkaConfig {
	
	@Autowired
	kafkaConfiguration kafkaConfiguration;
	
	@Bean
	public ProducerFactory<Integer, String> producerFactory() {
		return new DefaultKafkaProducerFactory<>(producerConfigs());
	}
    
    @Bean
	public Map<String, Object> producerConfigs() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaConfiguration.getKafkaBootstrapServers());
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		return config;
	}
   
    @Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		Map<String, Object> producerConfigs = producerConfigs();
		ProducerFactory<String, String> pf = new DefaultKafkaProducerFactory<String, String>(producerConfigs);
		KafkaTemplate<String, String> template = new KafkaTemplate<>(pf);
		return template;
	}
	
	//============ End : Kafka Producer Configuration ===============//
	
	// ========== Started: Kafka Consumer Configuration ==============//
	
	 @Bean
		KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer, String>> kafkaListenerContainerFactory() {
			ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
			factory.setConsumerFactory(consumerFactory());
			factory.setConcurrency(kafkaConfiguration.getMessageConsumerConcurrentWorkerCount());
			factory.getContainerProperties().setPollTimeout(kafkaConfiguration.getMessagePollTimeoutInMillis());
			factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
			return factory;
		}
	
	@Bean
	public ConsumerFactory<Integer, String> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerConfigs());
	}
	
	@Bean
	public Map<String, Object> consumerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfiguration.getKafkaBootstrapServers());
		props.put(ConsumerConfig.GROUP_ID_CONFIG,"sample-group");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);

		return props;
	}
    
}
