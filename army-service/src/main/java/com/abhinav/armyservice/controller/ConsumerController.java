package com.abhinav.armyservice.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(Sink.class)
public class ConsumerController {

    @StreamListener(Sink.INPUT)
    public void handleMessage(String msg) {
        System.out.println("Received: " + msg);
    }
}
