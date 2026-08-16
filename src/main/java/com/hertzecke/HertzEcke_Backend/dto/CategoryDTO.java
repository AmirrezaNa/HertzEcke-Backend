package com.hertzecke.HertzEcke_Backend.dto;

import com.hertzecke.HertzEcke_Backend.model.Category;
import com.hertzecke.HertzEcke_Backend.model.CategoryType;

public record CategoryDTO(Long id, String name, CategoryType categoryType, String slug) {

    public static CategoryDTO categoryEntityToDTO(Category category) {
        return new CategoryDTO(category.getId(),
                category.getName(),
                category.getCategoryType(),
                category.getSlug());
    }
}
