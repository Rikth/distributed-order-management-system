package com.Rikth.ordersystem.service;

import com.Rikth.ordersystem.dto.ReserveInventoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class InventoryClient {
    private final WebClient webClient;

    public void reserve(String productId, int quantity) {
        webClient.post()
                .uri("http://localhost:8081/inventory/reserve")
                .bodyValue(new ReserveInventoryRequest(productId, quantity))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
