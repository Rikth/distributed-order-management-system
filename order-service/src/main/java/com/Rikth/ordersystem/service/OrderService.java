package com.Rikth.ordersystem.service;

import com.Rikth.ordersystem.domain.Order;
import com.Rikth.ordersystem.domain.OrderItem;
import com.Rikth.ordersystem.domain.OrderStatus;
import com.Rikth.ordersystem.dto.CreateOrderRequest;
import com.Rikth.ordersystem.dto.OrderItemRequest;
import com.Rikth.ordersystem.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;



    public Order createOrder(CreateOrderRequest createOrderRequest){
        Order order = new Order();
        order.setCustomerId(createOrderRequest.getCustomerId());
        order.setStatus(OrderStatus.CREATED);
        order.setCreatedAt(LocalDateTime.now());

        double total = 0;

        for (OrderItemRequest orderItemRequest : createOrderRequest.getItems()){
            OrderItem item = OrderItem.builder().
                    productId(orderItemRequest.getProductId()).
                    quantity(orderItemRequest.getQuantity()).
                    price(orderItemRequest.getPrice()).
                    order(order).
                    build();

            total+= item.getQuantity()* item.getPrice();
            order.getItems().add(item);
        }

        order.setTotalAmt(total);
        return orderRepository.save(order);
    }
}
