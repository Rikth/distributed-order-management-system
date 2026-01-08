package com.Rikth.ordersystem.dto;

import com.Rikth.ordersystem.domain.OrderItem;
import lombok.Data;

import java.util.List;
@Data
public class CreateOrderRequest{
    private String customerId;
    private List<OrderItemRequest> items;
}
