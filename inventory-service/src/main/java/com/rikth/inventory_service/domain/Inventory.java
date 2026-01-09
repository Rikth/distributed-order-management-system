package com.rikth.inventory_service.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    private String productId;

    private Integer availableQuantity;
    private Integer reservedQuantity;

    protected Inventory() {
    }

    public Inventory(String productId, Integer availableQuantity) {
        this.productId = productId;
        this.availableQuantity = availableQuantity;
        this.reservedQuantity = 0;
    }

    public boolean canReserve(int quantity) {
        return availableQuantity >= quantity;
    }

    public void reserve(int quantity) {
        if (!canReserve(quantity)) {
            throw new IllegalArgumentException("Insufficient inventory to reserve");
        }
        this.availableQuantity -= quantity;
        this.reservedQuantity += quantity;
    }

    public void release(int quantity) {
        if (quantity > reservedQuantity) {
            throw new IllegalArgumentException("Cannot release more than reserved quantity");
        }
        this.availableQuantity += quantity;
        this.reservedQuantity -= quantity;
    }
}
