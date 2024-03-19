package com.mdk;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MessageQueueConfig
{
	public static final String MY_EXCHANGE  = "MyTopicExchange";
	public static final String MY_QUEUE     = "MyQueue";
	public static final String MY_ROUTE_KEY = "myRoutingKey";
	
	@Bean
	Exchange myExchange() {
		return ExchangeBuilder
			.topicExchange(MY_EXCHANGE)
			.durable(true)
			.build();
	}
	
	@Bean
	Queue myQueue() {
		return QueueBuilder
				.durable(MY_QUEUE)
				.build();
	}
	
	
	@Bean
	Binding myBinding() {
		return BindingBuilder
				.bind(myQueue())
				.to(myExchange())
				.with(MY_ROUTE_KEY)
				.noargs();
	}
}