package com.hertzecke.HertzEcke_Backend.repository;


import com.hertzecke.HertzEcke_Backend.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
