package com.example.rabbitmq.ex04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Producer {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Producer.class, args);
        Communicator.SendMessage("server.critical", "Im broken :(");
        Communicator.SendMessage("groupchat.random", "Check this anime girl images");
        Communicator.SendMessage("private.random", "tired of this sht");
        Communicator.SendMessage("kernel.critical", "*Said nothing, but in panic*");
        Communicator.SendMessage("groupchat.random", "Hi");
    }
}
