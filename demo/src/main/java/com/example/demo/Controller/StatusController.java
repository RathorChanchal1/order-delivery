package com.example.demo.Controller;

//import com.example.demo.Service.StatusStateMachineService;
import com.example.demo.Events.OrderEvent;
import com.example.demo.Kafka.NotificationProducer;
import com.example.demo.Model.Shopping;
import com.example.demo.Model.Status;

import com.example.demo.Service.StatusService;
import com.example.demo.States.OrderStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    // Get all statuses
    @GetMapping
    public ResponseEntity<List<Status>> getAllStatuses() {
        return ResponseEntity.ok(statusService.getAllStatuses());
    }
    private static final Logger log = LoggerFactory.getLogger(StatusController.class);
    // Update the status of an order


    @PostMapping("/{statusId}")
    public Status updateStatus(@PathVariable Long statusId,
                                               @RequestBody OrderEvent event) {
        log.info("Updating status with id {}", statusId);

        // Update the status and get the updated entity
        Status updatedStatus = statusService.updateOrderStatus(statusId, event);

        // Return the updated status
        return updatedStatus;
    }


}


//@RestController
//@RequestMapping("/api/v1/kafka")
//public class JsonMessageController {
//
//    private JsonKafkaProducer kafkaProducer;
//
//    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
//        this.kafkaProducer = kafkaProducer;
//    }
//
//    @PostMapping("/publish")
//    public ResponseEntity<String> publish(@RequestBody User user){
//        kafkaProducer.sendMessage(user);
//        return ResponseEntity.ok("Json message sent to kafka topic");
//    }
//}