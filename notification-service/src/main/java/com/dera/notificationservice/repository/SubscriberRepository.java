package com.dera.notificationservice.repository;

import com.dera.notificationservice.model.Subscriber;
import com.dera.notificationservice.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
    boolean existsByTopicAndUrl(Topic topic, String url);
    List<Subscriber> findAllByTopic_Name(String topicName);
}
