# HTTP-Notification-System
A Java based topic -> subscriber notification system built with Spring boot

The repository contains two services:
- A notification service With two endpoints; "/sunscribe/{topic}" to subscribe to a topic and "/publish/{topic}" to publsh a topic to all subscribers.

- A Subscriber service to receive the topic sent from the notification service. The subscriber service is used to validate that the topics published were received by the service.
