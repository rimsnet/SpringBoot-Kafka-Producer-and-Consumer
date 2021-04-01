package com.rimsan.springboot.kafka.messages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rimsan.springboot.kafka.config.kafkaConfiguration;

@Service
public class ItemProducer {
 
	private static final Logger logger = LoggerFactory.getLogger(ItemProducer.class);

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    @Autowired
	kafkaConfiguration kafkaConfiguration;
    
    
    public void publishItem(String invoiceJson) throws Exception {
        try {
            kafkaTemplate.send(kafkaConfiguration.getKafkaTopic(), invoiceJson);
        } catch (Exception e) {
            logger.info("Error occurred while publishing the invoice to Message broker.");
            throw e;
        }
    }
}
