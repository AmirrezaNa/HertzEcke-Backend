package com.hertzecke.HertzEcke_Backend.database_handling;

import com.hertzecke.HertzEcke_Backend.model.Category;
import com.hertzecke.HertzEcke_Backend.model.CategoryType;
import com.hertzecke.HertzEcke_Backend.model.MenuItem;
import com.hertzecke.HertzEcke_Backend.repository.CategoryRepository;
import com.hertzecke.HertzEcke_Backend.repository.MenuItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    private final MenuItemRepository menuItemRepository;


    public DataSeeder(CategoryRepository categoryRepository, MenuItemRepository menuItemRepository) {
        this.categoryRepository = categoryRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            createCategories();
        }
        if (menuItemRepository.count() == 0) {
            createMenuItems();
        }
    }

    public void createCategories() {
        Category softDrinks = new Category("Soft drinks", CategoryType.DRINK);
        Category lemonades = new Category("Lemonades", CategoryType.DRINK);

        Category snacks = new Category("Sides", CategoryType.FOOD);
        Category croques = new Category("Croques", CategoryType.FOOD);

        categoryRepository.save(softDrinks);
        categoryRepository.save(lemonades);

        categoryRepository.save(snacks);
        categoryRepository.save(croques);
    }

    public void createMenuItems() {
        Category category_softDrinks = categoryRepository.findCategoryByName("Soft drinks");
        MenuItem cocaCola = new MenuItem("Coca-Cola ( Flasche )", "Coca-Cola", new BigDecimal("2.90"));
        MenuItem fanta = new MenuItem("Fanta", "Fanta", new BigDecimal("2.90"));
        category_softDrinks.addMenuItem(cocaCola);
        category_softDrinks.addMenuItem(fanta);

        Category category_sides = categoryRepository.findCategoryByName("Sides");
        MenuItem nachos = new MenuItem("Nachos", "Nachos", new BigDecimal("4.90"));
        category_sides.addMenuItem(nachos);

        Category category_croques = categoryRepository.findCategoryByName("Croques");
        MenuItem cole_slaw = new MenuItem("Cole slaw", "Cole slaw", new BigDecimal("2.90"));
        category_croques.addMenuItem(cole_slaw);

        categoryRepository.save(category_softDrinks);
        categoryRepository.save(category_sides);
        categoryRepository.save(category_croques);
    }
}
