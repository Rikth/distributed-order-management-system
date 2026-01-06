package com.Rikth.ordersystem.service;

import com.Rikth.ordersystem.domain.Order;
import com.Rikth.ordersystem.domain.OrderStatus;
import com.Rikth.ordersystem.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
//@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(String customerId, Double totalAmt){
//        Order order = Order.builder().
//                customerId(customerId).
//                status(OrderStatus.CREATED).
//                totalAmt(totalAmt).
//                createdAt(LocalDateTime.now()).build();

        Order order = new Order();
        order.setCustomerId(customerId);
        order.setStatus(OrderStatus.CREATED);
        order.setTotalAmt(totalAmt);
        order.setCreatedAt(LocalDateTime.now());

        return orderRepository.save(order);
    }
}
