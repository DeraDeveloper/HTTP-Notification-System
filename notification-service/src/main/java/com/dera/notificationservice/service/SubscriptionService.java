package com.dera.notificationservice.service;

import com.dera.notificationservice.request.SubscriptionRequest;
import com.dera.notificationservice.response.SubscriptionResponse;

import java.util.List;

public interface SubscriptionService {
    public SubscriptionResponse createSubscription(String topic, SubscriptionRequest subscriptionRequest);
    public List<String> getAllSubscriberUrlsByTopic(String topic);
}
