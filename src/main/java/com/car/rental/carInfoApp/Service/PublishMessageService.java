package com.car.rental.carInfoApp.Service;

import java.util.List;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublishMessageService {
	
	@Autowired
    private Queue queue;

	
    @Autowired
    private JmsTemplate jmsTemplate;

    public void publish(/*long carId */ byte[] bs){
        //jmsTemplate.convertAndSend(queue, cardId,price);
    	//jmsTemplate.convertAndSend(queue,carId);
    	jmsTemplate.convertAndSend(queue,bs);
    	
    	
        
    }
    
}
