package com.hertzecke.HertzEcke_Backend.repository;

import com.hertzecke.HertzEcke_Backend.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
