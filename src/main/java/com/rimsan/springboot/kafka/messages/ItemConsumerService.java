package com.rimsan.springboot.kafka.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.rimsan.springboot.kafka.config.kafkaConfiguration;

@Service
public class ItemConsumerService {
	
	@Autowired
	kafkaConfiguration kafkaConfiguration;
	
	
	@KafkaListener(topics = "helloTopic", groupId = "sample-group",containerFactory = "kafkaListenerContainerFactory")
    public void consume(String item){
        System.out.println("Consumed Message :"+item);
    }
}
