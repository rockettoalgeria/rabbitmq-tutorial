package com.example.rabbitmq.ex00;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sender {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Sender.class, args);
        Communicator.SendMessage("Hello there!");
    }

}
