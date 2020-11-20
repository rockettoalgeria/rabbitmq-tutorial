package com.example.rabbitmq.ex01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskSender {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(TaskSender.class, args);
        Communicator.SendMessage("beep.beep.bop");
        Communicator.SendMessage("beep.bop");
        Communicator.SendMessage("beep.beep.bop.beep");
        Communicator.SendMessage("heavy.task.coming!BEEP...BOP..");
    }

}
