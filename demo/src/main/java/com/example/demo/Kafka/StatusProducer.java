//package com.example.demo.Kafka;
//
//import com.example.demo.Model.Status;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class StatusProducer {
//    @Value("${spring.kafka.topic.topic4}")
//    private String statusTopic;
//    private KafkaTemplate<String, Status> kafkaTemplate;
//    public StatusProducer(KafkaTemplate<String, Status> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    public void activateStatus(Status status) {
//        Message<Status> messagae = MessageBuilder
//                .withPayload(status)
//                .setHeader(KafkaHeaders.TOPIC, statusTopic).build();
//        kafkaTemplate.send(messagae);
//    }
//
//}



//@Service
//public class NotificationProducer {
//
//    @Value("${spring.kafka.topic.topic3}")
//    private String notificationTopic;
//    private static final Logger logger = LoggerFactory.getLogger(NotificationProducer.class);
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    public NotificationProducer(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//    public void sendMessage(String msg) {
//        logger.info("Sending message to topic {}", notificationTopic);
//        Message<String> message = MessageBuilder
//                .withPayload(msg)
//                .setHeader(KafkaHeaders.TOPIC, notificationTopic).build();
//
//        kafkaTemplate.send(message);
//    }
//}
