package com.mdk;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMqDemoAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqDemoAppApplication.class, args);
	}

	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		MessageQueueConfig mqc = new MessageQueueConfig();
		
		//rabbitTemplate.convertAndSend(mqc.MY_EXCHANGE, mqc.MY_ROUTE_KEY, "message from Spring APP");
		
		rabbitTemplate.convertAndSend(mqc.MY_EXCHANGE, mqc.MY_ROUTE_KEY, SampleMessage.send("Time is : ", LocalDateTime.now().toString()) );
		
	}

}
