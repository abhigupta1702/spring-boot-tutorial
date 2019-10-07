package com.abhinav.armyservice.controller;

import lombok.SneakyThrows;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(Sink.class)
public class ConsumerController {

    @StreamListener(Sink.INPUT)
    @SneakyThrows
    public void handleMessage(String msg) {
        System.out.println("Step1 - Received: " + msg);
        if (msg.equals("Test1"))
            throw new Exception("basnmdbsad");
        Thread.sleep(20000);
        System.out.println("Step2 - Received: " + msg);
    }
}
