package com.hertzecke.HertzEcke_Backend.repository;

import com.hertzecke.HertzEcke_Backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryByName(String name);
}
