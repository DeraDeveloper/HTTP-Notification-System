package com.dera.subscriberservice.controller;

import com.dera.subscriberservice.SubscriberRequest;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class SubscriberController {

    @PostMapping("test1")
    public void printMessageSentToTopic1(@RequestBody SubscriberRequest request){
        log.info("Received message on /test1 endpoint\n" + getRequestString(request));
    }

    @PostMapping("test2")
    public void printMessageSentToTopic2(@RequestBody  SubscriberRequest request){
        log.info("Received message on /test1 endpoint\n" + getRequestString(request));
    }

    private String getRequestString(SubscriberRequest request){
        Gson gson = new Gson();
        return gson.toJson(request);
    }
}
