package com.example.rabbitmq.ex01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Worker_2 {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Worker_2.class, args);
		Communicator.ListenChannel();
	}

}