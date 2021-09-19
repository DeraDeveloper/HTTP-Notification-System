package com.dera.notificationservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final ExternalRestService externalRestService;
    @Async
    public void publish(List<String> subscribers, String topicName, Map<String, Object> request) {
        for (String url: subscribers) {
            externalRestService.postRequest(url, topicName, request);
        }
    }
}
