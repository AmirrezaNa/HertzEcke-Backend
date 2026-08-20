package com.hertzecke.HertzEcke_Backend.dto;

import com.hertzecke.HertzEcke_Backend.model.Order;
import com.hertzecke.HertzEcke_Backend.model.OrderItem;

import java.util.List;

public record OrderDTO(Long id, String name, String phoneNumber, List<OrderItem> orderItems) {

    public static OrderDTO orderEntityToDTO(Order order) {
        return new OrderDTO(order.getId(),
                order.getName(),
                order.getPhoneNumber(),
                order.getOrderItems());
    }
}
