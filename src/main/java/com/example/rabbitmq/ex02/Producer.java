package com.example.rabbitmq.ex02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Producer {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Producer.class, args);
        Communicator.SendMessage("Hello");
        Communicator.SendMessage("what's up?");
        Communicator.SendMessage("Someone hears me?");
        Communicator.SendMessage("OK, I said enough");
    }
}
