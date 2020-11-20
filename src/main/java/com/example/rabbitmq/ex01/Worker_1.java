package com.example.rabbitmq.ex01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Worker_1 {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Worker_1.class, args);
		Communicator.ListenChannel();
	}

}