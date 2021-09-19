package com.dera.notificationservice.service;

import java.util.Map;

public interface PublicationService {
    void publishTopic(String topicName, Map<String, Object> publishRequest);
}
