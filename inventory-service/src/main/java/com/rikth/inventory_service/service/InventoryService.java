package com.rikth.inventory_service.service;

import com.rikth.inventory_service.domain.Inventory;
import com.rikth.inventory_service.repository.InventoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public boolean reserve(String productId, int quantity) {
        Inventory inventory = inventoryRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if(!inventory.canReserve(quantity)){
            return false;
        }
        inventory.reserve(quantity);
        return true;
    }
}
