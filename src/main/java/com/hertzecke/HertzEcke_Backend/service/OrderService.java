package com.hertzecke.HertzEcke_Backend.service;


import com.hertzecke.HertzEcke_Backend.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
