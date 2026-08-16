package com.hertzecke.HertzEcke_Backend.service;


import com.hertzecke.HertzEcke_Backend.dto.MenuItemDTO;
import com.hertzecke.HertzEcke_Backend.repository.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;

    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItemDTO> getAllMenuItems() {
        return menuItemRepository.findAll()
                .stream()
                .map(MenuItemDTO::menuItemEntityToDTO)
                .toList();
    }

    public Optional<MenuItemDTO> getMenuItemById(Long id) {
        return menuItemRepository.findById(id)
                .map(MenuItemDTO::menuItemEntityToDTO);
    }

}
