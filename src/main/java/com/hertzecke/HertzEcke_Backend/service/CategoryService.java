package com.hertzecke.HertzEcke_Backend.service;


import com.hertzecke.HertzEcke_Backend.dto.CategoryDTO;
import com.hertzecke.HertzEcke_Backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryDTO::categoryEntityToDTO)
                .toList();
    }
}
