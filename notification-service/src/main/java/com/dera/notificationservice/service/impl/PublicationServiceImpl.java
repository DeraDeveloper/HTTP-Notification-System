package com.dera.notificationservice.service.impl;

import com.dera.notificationservice.service.PublicationService;
import com.dera.notificationservice.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PublicationServiceImpl implements PublicationService {
    private final SubscriptionService subscriptionService;
    private final NotificationService notificationService;

    @Override
    public void publishTopic(String topicName, Map<String, Object> publishRequest) {
        List<String> subscribers = subscriptionService.getAllSubscriberUrlsByTopic(topicName);
        if(!subscribers.isEmpty()){
            notificationService.publish(subscribers, topicName, publishRequest);
        }
    }
}
