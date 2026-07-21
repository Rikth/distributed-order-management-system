package com.Rikth.ordersystem.dto;

import com.Rikth.ordersystem.domain.OrderItem;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;
@Data
public class CreateOrderRequest{

    @NotBlank(message = "Customer ID cannot be blank")
    private String customerId;

    @NotEmpty(message = "Order must contain at least one item")
    @Valid
    private List<OrderItemRequest> items;
}
