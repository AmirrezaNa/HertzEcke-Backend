package com.hertzecke.HertzEcke_Backend.dto;

import com.hertzecke.HertzEcke_Backend.model.MenuItem;
import java.math.BigDecimal;

public record MenuItemDTO (Long id,
                           String nameDe,
                           String nameEn,
                           String descriptionDe,
                           String descriptionEn,
                           String size,
                           String imageUrl,
                           boolean available,
                           BigDecimal price,
                           CategoryDTO categoryDTO){
    public static MenuItemDTO menuItemEntityToDTO(MenuItem menuItem) {
        if (menuItem==null) return null;
        return new MenuItemDTO(menuItem.getId(),
                menuItem.getNameDe(),
                menuItem.getNameEn(),
                menuItem.getDescriptionDe(),
                menuItem.getDescriptionEn(),
                menuItem.getSize(),
                menuItem.getImageUrl(),
                menuItem.isAvailable(),
                menuItem.getPrice(),
                CategoryDTO.categoryEntityToDTO(menuItem.getCategory()));
    }

}
