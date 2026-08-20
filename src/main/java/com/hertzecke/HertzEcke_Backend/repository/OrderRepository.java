package com.hertzecke.HertzEcke_Backend.repository;


import com.hertzecke.HertzEcke_Backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
