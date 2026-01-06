package com.Rikth.ordersystem.repository;

import com.Rikth.ordersystem.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
