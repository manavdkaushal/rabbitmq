package com.mdk;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class MyMessageListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		System.out.println("Received Message is : [ "+ new String(message.getBody()) + " ] ");
		
	}


}
