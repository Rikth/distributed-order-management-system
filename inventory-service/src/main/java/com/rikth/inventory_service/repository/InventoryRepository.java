package com.rikth.inventory_service.repository;

import com.rikth.inventory_service.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, String> {
}
