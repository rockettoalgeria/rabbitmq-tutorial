package com.example.rabbitmq.ex03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Producer {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Producer.class, args);
        Communicator.SendMessage("importantStuff", "F, all crashed and exploded, fix it, pls!");
        Communicator.SendMessage("junk","what's up?");
        Communicator.SendMessage("junk","Someone hears me?");
        Communicator.SendMessage("junk","OK, I said enough");
    }
}
