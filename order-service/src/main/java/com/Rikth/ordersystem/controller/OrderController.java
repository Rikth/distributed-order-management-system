package com.Rikth.ordersystem.controller;

import com.Rikth.ordersystem.domain.Order;
import com.Rikth.ordersystem.dto.CreateOrderRequest;
import com.Rikth.ordersystem.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody CreateOrderRequest request){
        return orderService.createOrder(request);
    }

}
