package com.Rikth.ordersystem.controller;

import com.Rikth.ordersystem.domain.Order;
import com.Rikth.ordersystem.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
//@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping
    public Order createOrder(@RequestParam String customerId, @RequestParam Double amount){
        return orderService.createOrder(customerId, amount);
    }

}
