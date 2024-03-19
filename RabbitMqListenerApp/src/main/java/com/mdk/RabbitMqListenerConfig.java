package com.mdk;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqListenerConfig {

	public static final String MY_QUEUE = "MyQueue";
	
	@Bean
	Queue myQueue() {
		return QueueBuilder
				.durable(MY_QUEUE)
				.build(); //new Queue(MY_QUEUE, true);
	}

	@Bean
	ConnectionFactory connFactory() {
		CachingConnectionFactory ccf = new CachingConnectionFactory("localhost");
		ccf.setUsername("guest");
		ccf.setPassword("guest");
		
		return ccf;		
	}

	@Bean
	MessageListenerContainer mlc() {
		SimpleMessageListenerContainer smlc = new SimpleMessageListenerContainer();
		smlc.setConnectionFactory(connFactory());
		smlc.setQueues(myQueue());
		smlc.setMessageListener(new MyMessageListener());
		return smlc;
	}
}
