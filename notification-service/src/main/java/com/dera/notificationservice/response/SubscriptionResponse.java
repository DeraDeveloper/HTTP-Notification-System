package com.dera.notificationservice.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubscriptionResponse {
    private String url;
    private String topic;
}
