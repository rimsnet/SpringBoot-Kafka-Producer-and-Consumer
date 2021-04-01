package com.rimsan.springboot.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rimsan.springboot.kafka.messages.ItemProducer;
import com.rimsan.springboot.kafka.model.Item;

@RestController
@RequestMapping("producer")
public class HelloController {

	    @Autowired
	    ObjectMapper objectMapper;
	    
	    @Autowired
	    ItemProducer itemProducer;

	    @PostMapping(value = "/postItem",consumes = {"application/json"},produces = {"application/json"})
	    public String postJsonMessage(@RequestBody Item item) {
	    	
	        try {
	        	String itemStr=objectMapper.writeValueAsString(item);
	        	itemProducer.publishItem(itemStr);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return "Message published successfully";
	    }
}
