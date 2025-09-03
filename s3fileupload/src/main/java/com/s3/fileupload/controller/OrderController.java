package com.s3.fileupload.controller;

import com.s3.fileupload.service.OrderService;
import com.s3.fileupload.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadOrders(@RequestBody List<Order> orders) {
        try {
            String key = orderService.uploadListOfOrders(orders);
            return ResponseEntity.ok("Orders uploaded to S3 with key: " + key);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Upload failed: " + e.getMessage());
        }
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        System.out.println("GET /api/orders/ping request received");
        return ResponseEntity.ok("Pong");
    }
}