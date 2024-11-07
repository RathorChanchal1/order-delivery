package com.example.demo.Controller;

//import com.example.demo.KafkaProducers.PaymentProducer;
import com.example.demo.Model.Payment;
import com.example.demo.Model.Shopping;
import com.example.demo.Repository.PaymentRepo;
import com.example.demo.Service.OrderService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;


//
import com.example.demo.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
//http://localhost:8083/payment/payments
@CrossOrigin(origins = "http://localhost:8083")
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payments/{paymentId}")
    public ResponseEntity<Optional<Payment>> getPaymentById(@PathVariable long paymentId) {
        Optional<Payment> payment = paymentService.getPaymentById(paymentId);
        if (payment.isPresent()) {
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/payments")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        try {
            Payment _payment = paymentService.createPayment(payment);
            return new ResponseEntity<>(_payment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //kafka modifications
//    @PostMapping("/process")
//    public String processPayment(@RequestBody Payment payment) {
//        paymentService.processPayment(payment);
//        return "Payment processed successfully";
//    }

//    private PaymentProducer kafkaProducer;
//
//    public PaymentController(PaymentProducer kafkaProducer) {
//        this.kafkaProducer = kafkaProducer;
//    }
//
//    @PostMapping("/publish")
//    public ResponseEntity<String> publish(@RequestBody Payment user){
//        kafkaProducer.sendMessage(user);
//        return ResponseEntity.ok("Json message sent to kafka topic");
//    }
}

//    @Autowired
//    private PaymentRepo paymentRepository;
//
//    @Autowired
//    private OrderService orderService;
//
//    // Endpoint to create a new payment entry
//    @PostMapping
//    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
//        Payment savedPayment = paymentRepository.save(payment);
//        return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
//    }
//
//    // Endpoint to process payment and move cart to order
//    @PostMapping("/process/{cartPaymentId}")
//    public ResponseEntity<String> processPayment(@PathVariable("cartPaymentId") long cartPaymentId) {
//        try {
//            orderService.processPaymentAndMoveToOrder(cartPaymentId);
//            return new ResponseEntity<>("Payment processed and cart moved to order", HttpStatus.OK);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // Endpoint to get payment by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") long id) {
//        Optional<Payment> paymentOptional = paymentRepository.findById(id);
//        return paymentOptional
//                .map(payment -> new ResponseEntity<>(payment, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

    //modifications




    //modifications
//    @PostMapping
//    public ResponseEntity<Payment>
//    post(@RequestBody Payment paymentData)
//    {
//        HttpHeaders headers = new HttpHeaders();
//        return new ResponseEntity<>(paymentData, headers,
//                HttpStatus.CREATED);
//    }
//
//    @GetMapping("/paymentConformation")
//    public ResponseEntity<Payment> paymentConfirmation(){
//
//    }

//}