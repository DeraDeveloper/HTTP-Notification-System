package com.dera.notificationservice.service.impl;

import com.dera.notificationservice.request.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ExternalRestService {

    private final RestTemplate restTemplate;

    @Async
    public void postRequest(String url, String topic, Map<String, Object> request) {
        NotificationRequest notificationRequest = NotificationRequest.builder().topic(topic).data(request).build();
        ResponseEntity<Void> response = restTemplate.postForEntity(url, notificationRequest, Void.class);
    }
}
