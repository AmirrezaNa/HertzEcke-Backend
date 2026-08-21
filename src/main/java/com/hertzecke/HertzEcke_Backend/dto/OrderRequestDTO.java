package com.hertzecke.HertzEcke_Backend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

// Shape of the checkout payload the frontend sends.
// Only IDs + amounts are trusted from the client — prices are always looked up server-side.
public record OrderRequestDTO(
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Phone number is required")
        String phoneNumber,

        @NotEmpty(message = "There must be items for ordering")
        @Valid
        List<OrderItemRequestDTO> items) {

    public record OrderItemRequestDTO(
            @NotNull(message = "Menu item ID is required")
            Long menuItemId,

            @Min(value = 1, message = "Amount must be at least 1")
            int amount
    ) {
    }
}
