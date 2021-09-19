package com.dera.notificationservice.service.impl;

import com.dera.notificationservice.model.Subscriber;
import com.dera.notificationservice.model.Topic;
import com.dera.notificationservice.repository.SubscriberRepository;
import com.dera.notificationservice.repository.TopicRepository;
import com.dera.notificationservice.request.SubscriptionRequest;
import com.dera.notificationservice.response.SubscriptionResponse;
import com.dera.notificationservice.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriberRepository subscriberRepository;
    private final TopicRepository topicRepository;

    //create topic if it doesn't exist
    @Override
    public SubscriptionResponse createSubscription(String topicName, SubscriptionRequest subscriptionRequest) {
        String url = subscriptionRequest.getUrl();
        Topic topic = getOrCreate(topicName);
        if(!subscriberExistsForTopic(topic, url)){
            subscriberRepository.save(
                    Subscriber.builder().topic(topic).url(url).build());
        }
        return buildSubscriptionResponse(topicName, url);
    }

    @Override
    public List<String> getAllSubscriberUrlsByTopic(String topic) {
        return subscriberRepository.findAllByTopic_Name(topic).stream().map(Subscriber::getUrl).collect(Collectors.toList());
    }

    private boolean subscriberExistsForTopic(Topic topic, String url){
        return subscriberRepository.existsByTopicAndUrl(topic, url);
    }

    private Topic getOrCreate(String topic){
        return topicRepository.findByName(topic).orElseGet(() -> topicRepository.save(
                Topic.builder().name(topic).build()));
    }

    private SubscriptionResponse buildSubscriptionResponse(String topicName, String url){
        return SubscriptionResponse.builder()
                .topic(topicName)
                .url(url)
                .build();
    }

}
