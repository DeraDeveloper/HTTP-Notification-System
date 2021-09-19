package com.dera.notificationservice.controller;

import com.dera.notificationservice.service.PublicationService;
import com.dera.notificationservice.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.dera.notificationservice.request.SubscriptionRequest;
import com.dera.notificationservice.response.SubscriptionResponse;

import java.util.Map;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class NotificationController {

    private final SubscriptionService subscriptionService;
    private final PublicationService publicationService;

    @PostMapping("subscribe/{topic}")
    public SubscriptionResponse subscribeToTopic(@PathVariable("topic")String topic,
                                                 @Validated @RequestBody SubscriptionRequest subscriptionRequest){
        return subscriptionService.createSubscription(topic, subscriptionRequest);
    }

    @PostMapping("publish/{topic}")
    public void publishTopic(@PathVariable("topic")String topic,
                             @RequestBody Map<String, Object> publishRequest){
        publicationService.publishTopic(topic, publishRequest);
    }
}
