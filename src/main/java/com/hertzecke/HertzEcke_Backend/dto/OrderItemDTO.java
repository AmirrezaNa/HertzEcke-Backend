package com.hertzecke.HertzEcke_Backend.dto;

import com.hertzecke.HertzEcke_Backend.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

public record OrderItemDTO(Long id, MenuItemDTO menuItemDTO, int amount) {
    public static OrderItemDTO orderItemEntityToDTO(OrderItem orderItem) {
        return new OrderItemDTO(orderItem.getId(),
                MenuItemDTO.menuItemEntityToDTO(orderItem.getMenuItem()),
                orderItem.getAmount());
    }

    public static List<OrderItemDTO> orderItemsListToDTO(List<OrderItem> orderItems) {
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            OrderItemDTO orderItemDTO = orderItemEntityToDTO(orderItem);
            orderItemDTOS.add(orderItemDTO);
        }
        return orderItemDTOS;
    }
}
