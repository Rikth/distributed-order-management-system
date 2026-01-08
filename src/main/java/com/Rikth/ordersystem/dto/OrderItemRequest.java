package com.Rikth.ordersystem.dto;

import lombok.Data;

@Data
public class OrderItemRequest {
    private String productId;
    private Integer quantity;
    private Double price;
}
