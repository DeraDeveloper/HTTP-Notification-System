package com.dera.notificationservice.request;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class NotificationRequest {
    private String topic;
    private Map<String, Object> data;
}
