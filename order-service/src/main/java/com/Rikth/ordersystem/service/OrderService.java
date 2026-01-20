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
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final InventoryClient inventoryClient;

    public Order createOrder(CreateOrderRequest createOrderRequest){
        Order order = Order.builder()
                .customerId(createOrderRequest.getCustomerId())
                .createdAt(LocalDateTime.now())
                .status(OrderStatus.PENDING)
                .items(new ArrayList<>())
                .build();

        double total = 0;

        for (OrderItemRequest orderItemRequest : createOrderRequest.getItems()){
            try {
                inventoryClient.reserve(orderItemRequest.getProductId(), orderItemRequest.getQuantity());
            } catch (Exception e){
                order.setStatus(OrderStatus.CANCELLED);
                throw new RuntimeException("Failed to reserve inventory for product: " + orderItemRequest.getProductId());
            }

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
        order.setStatus(OrderStatus.CONFIRMED);
        return orderRepository.save(order);
    }
}
