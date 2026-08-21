package com.hertzecke.HertzEcke_Backend.dto;

import com.hertzecke.HertzEcke_Backend.model.Order;
import com.hertzecke.HertzEcke_Backend.model.OrderStatus;

import java.math.BigDecimal;
import java.util.List;

public record OrderDTO(Long id, String name, String phoneNumber, List<OrderItemDTO> orderItems,
                       BigDecimal totalPrice, OrderStatus status) {

    public static OrderDTO orderEntityToDTO(Order order) {
        return new OrderDTO(order.getId(),
                order.getName(),
                order.getPhoneNumber(),
                OrderItemDTO.orderItemsListToDTO(order.getOrderItems()),
                order.getTotalPrice(),
                order.getStatus());
    }
}
