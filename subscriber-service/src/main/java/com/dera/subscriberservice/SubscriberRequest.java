package com.dera.subscriberservice;

import lombok.Data;

import java.util.Map;

@Data
public class SubscriberRequest {
    private String topic;
    private Map<String, Object> data;
}
