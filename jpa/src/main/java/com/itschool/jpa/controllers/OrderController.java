package com.itschool.jpa.controllers;

import com.itschool.jpa.dtos.RequestOrderDto;
import com.itschool.jpa.models.Order;
import com.itschool.jpa.models.OrderItem;
import com.itschool.jpa.services.OrderService;
import com.itschool.jpa.services.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody RequestOrderDto orderDto) {
        System.out.println("Sunt in placeOrder");
        Order order = service.placeOrder(orderDto.getUserId(), orderDto.getItems());
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> ordersWithPagination(@RequestParam Long userId, @RequestParam int page, @RequestParam int size) {
        List<Order> orders = service.getOrdersWithPagination(userId, page, size);
        return ResponseEntity.ok(orders);
    }
}
