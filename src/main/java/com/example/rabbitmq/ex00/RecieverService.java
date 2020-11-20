package com.example.rabbitmq.ex00;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecieverService {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RecieverService.class, args);
		Communicator.ListenChannel();
	}

}