package com.Rikth.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ReserveInventoryRequest {
    private String productId;
    private int quantity;
}
