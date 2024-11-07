package com.example.demo.Kafka;

import com.example.demo.Events.OrderEvent;
import com.example.demo.States.OrderStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

    @Value("${spring.kafka.topic.topic3}")
    private String notificationTopic;
    private static final Logger logger = LoggerFactory.getLogger(NotificationProducer.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    public NotificationProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(String msg) {
        logger.info("Sending message to topic {}", notificationTopic);
        Message<String> message = MessageBuilder
                .withPayload(msg)
                .setHeader(KafkaHeaders.TOPIC, notificationTopic).build();

        kafkaTemplate.send(message);
    }
}


//    @Value("${spring.kafka.topic.topic3}")
//    private String notificationTopic;
//    private static final Logger logger = LoggerFactory.getLogger(NotificationProducer.class);
//    private KafkaTemplate<String, OrderStatus> kafkaTemplate;
//
//    public NotificationProducer(KafkaTemplate<String, OrderStatus> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//    public void sendMessage(OrderStatus orderStatus) {
//        logger.info("Sending message to topic {}", notificationTopic);
//        Message<OrderStatus> message = MessageBuilder
//                .withPayload(orderStatus)
//                .setHeader(KafkaHeaders.TOPIC, notificationTopic).build();
//
//        kafkaTemplate.send(message);
//    }

//
//@Value("${spring.kafka.topic-json.name}")
//private String topicJsonName;
//
//private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
//
//private KafkaTemplate<String, User> kafkaTemplate;
//
//public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
//    this.kafkaTemplate = kafkaTemplate;
//}
//
//public void sendMessage(User data){
//
//    LOGGER.info(String.format("Message sent -> %s", data.toString()));
//
//    Message<User> message = MessageBuilder
//            .withPayload(data)
//            .setHeader(KafkaHeaders.TOPIC, topicJsonName)
//            .build();
//
//    kafkaTemplate.send(message);
//}