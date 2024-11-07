package com.example.Notification.Kafka;

//import com.example.Notification.States.OrderStatus;
import com.example.Notification.States.OrderStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "${spring.kafka.topic.topic3}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(String orderStatus){
        logger.info("Consumer received: " + orderStatus);
    }

}
//@Service
//public class JsonKafkaConsumer {
//    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
//
//    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
//    public void consume(User user){
//        LOGGER.info(String.format("Json message recieved -> %s", user.toString()));
//    }
//}
