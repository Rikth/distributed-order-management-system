package com.rikth.inventory_service.config;

import com.rikth.inventory_service.domain.Inventory;
import com.rikth.inventory_service.repository.InventoryRepository;

public class DataLoader {

    public DataLoader(InventoryRepository repo){
        repo.save(new Inventory("P1", 10));
        repo.save(new Inventory("P2", 5));
    }
}
