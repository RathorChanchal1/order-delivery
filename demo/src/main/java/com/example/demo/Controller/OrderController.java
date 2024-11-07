package com.example.demo.Controller;



import com.example.demo.Model.Order;
import com.example.demo.Model.Shopping;
import com.example.demo.Model.Status;
import com.example.demo.Repository.OrderRepo;
import com.example.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//http://localhost:8083/orders/allOrders
@CrossOrigin(origins = "http://localhost:8083")
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/process/{cartPaymentId}")
    public ResponseEntity<String> processOrder(@PathVariable long cartPaymentId) {
        try {
            orderService.processPaymentAndMoveToOrder(cartPaymentId);
            return new ResponseEntity<>("Order processed successfully!", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable long orderId) {
        try {
            Order order = orderService.getOrderById(orderId);
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/allOrders")
    public ResponseEntity<List<Order>> getAllOrders(@RequestParam(required = false) Long id) {
        try {
            List<Order> orders = orderService.getAllOrders(id);
//            Status status = new Status();
//            orderService.activeStatus(status);
            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}