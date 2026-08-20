package com.hertzecke.HertzEcke_Backend.dto;

import java.util.List;

// Shape of the checkout payload the frontend sends.
// Only IDs + amounts are trusted from the client — prices are always looked up server-side.
public record OrderRequestDTO(String name, String phoneNumber, List<OrderItemRequestDTO> items) {

    public record OrderItemRequestDTO(Long menuItemId, int amount) {
    }
}
