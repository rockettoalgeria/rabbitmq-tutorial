package com.example.rabbitmq.ex04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Consumer_2 {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Consumer_2.class, args);
		Communicator.ListenChannel("server.critical", "#.random");
	}

}