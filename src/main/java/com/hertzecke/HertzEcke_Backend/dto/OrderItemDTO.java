package com.hertzecke.HertzEcke_Backend.dto;

import com.hertzecke.HertzEcke_Backend.model.MenuItem;
import com.hertzecke.HertzEcke_Backend.model.OrderItem;

public record OrderItemDTO(Long id, MenuItemDTO menuItemDTO, int amount) {
    public static OrderItemDTO OrderItemEntityToDTO(OrderItem orderItem) {
        return new OrderItemDTO(orderItem.getId(),
                MenuItemDTO.menuItemEntityToDTO(orderItem.getMenuItem()),
                orderItem.getAmount());
    }
}
