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
        /*
       if (categoryRepository.count() == 0) {
            createCategories();
        }
        if (menuItemRepository.count() == 0) {
            createMenuItems();
        }
        */

        menuItemRepository.deleteAll();
        categoryRepository.deleteAll();

        createCategories();
        createMenuItems();

    }


    public void createCategories() {
        Category softDrinks = new Category("Soft drinks", CategoryType.DRINK);
        softDrinks.setSlug("soft");
        categoryRepository.save(softDrinks);

        Category lemonades = new Category("Lemonades", CategoryType.DRINK);
        lemonades.setSlug("lemonades");
        categoryRepository.save(lemonades);

        Category icedTea = new Category("Iced Tea", CategoryType.DRINK);
        icedTea.setSlug("icedtea");
        categoryRepository.save(icedTea);

        Category sparklingAndAperitif = new Category("Sparkling & Aperitif", CategoryType.DRINK);
        sparklingAndAperitif.setSlug("sparkling");
        categoryRepository.save(sparklingAndAperitif);

        Category wine = new Category("Wine", CategoryType.DRINK);
        wine.setSlug("wine");
        categoryRepository.save(wine);

        Category beer = new Category("Beer", CategoryType.DRINK);
        beer.setSlug("beer");
        categoryRepository.save(beer);

        Category caribbeanAndFancy = new Category("Caribbean & Fancy", CategoryType.DRINK);
        caribbeanAndFancy.setSlug("caribbean");
        categoryRepository.save(caribbeanAndFancy);

        Category modernClassic = new Category("Modern Classics", CategoryType.DRINK);
        modernClassic.setSlug("modern");
        categoryRepository.save(modernClassic);

        Category soursAndFizzes = new Category("Sours & Fizzes", CategoryType.DRINK);
        soursAndFizzes.setSlug("sours");
        categoryRepository.save(soursAndFizzes);

        Category alcoholFree = new Category("Alcohol-free cocktails", CategoryType.DRINK);
        alcoholFree.setSlug("driver");
        categoryRepository.save(alcoholFree);

        Category spirits = new Category("Spirits", CategoryType.DRINK);
        spirits.setSlug("spirits");
        categoryRepository.save(spirits);

        Category hotDrinks = new Category("Hot drinks", CategoryType.DRINK);
        hotDrinks.setSlug("hot");
        categoryRepository.save(hotDrinks);


        Category sides = new Category("Sides", CategoryType.FOOD);
        sides.setSlug("sides");
        categoryRepository.save(sides);

        Category snacks = new Category("Snacks", CategoryType.FOOD);
        snacks.setSlug("snacks");
        categoryRepository.save(snacks);

        Category croques = new Category("Croques", CategoryType.FOOD);
        croques.setSlug("croques");
        categoryRepository.save(croques);

        Category burger = new Category("Burger", CategoryType.FOOD);
        burger.setSlug("burger");
        categoryRepository.save(burger);

        Category salate = new Category("Salate", CategoryType.FOOD);
        salate.setSlug("salate");
        categoryRepository.save(salate);

        Category dessert = new Category("Dessert", CategoryType.FOOD);
        dessert.setSlug("dessert");
        categoryRepository.save(dessert);

        Category dips = new Category("Dips", CategoryType.FOOD);
        dips.setSlug("dips");
        categoryRepository.save(dips);
    }

    public void createMenuItems() {
        seedSoftDrinks();
        seedLemonadesAndIcedTea();
        seedSparklingAndWine();
        seedBeer();
        seedCocktails();
        seedSpiritsAndHotDrinks();
        seedFood();
    }

    private void seedSoftDrinks() {
        Category softDrinks = categoryRepository.findCategoryByName("Soft drinks");

        addMenuItemToCategory(softDrinks, "Coca-Cola (Flasche) 0.2L", "Coca-Cola", "2.90");
        addMenuItemToCategory(softDrinks, "Coca-Cola Zero (Flasche) 0.2L", "Coca-Cola Zero", "2.90");
        addMenuItemToCategory(softDrinks, "Fanta 0.2L", "Fanta", "2.90");
        addMenuItemToCategory(softDrinks, "Sprite 0.2L", "Sprite", "2.90");
        addMenuItemToCategory(softDrinks, "Mezzo Mix 0.2L", "Mezzo Mix", "2.90");
        addMenuItemToCategory(softDrinks, "Tonic Water", "Tonic Water", "3.90");
        addMenuItemToCategory(softDrinks, "Ginger Ale", "Ginger Ale", "3.90");
        addMenuItemToCategory(softDrinks, "Bitter Lemon", "Bitter Lemon", "3.90");
        addMenuItemToCategory(softDrinks, "Red Bull", "Red Bull", "4.90");

        addMenuItemToCategory(softDrinks, "Vio Still 0.2L", "Vio Still", "2.90");
        addMenuItemToCategory(softDrinks, "Vio Still 0.7L", "Vio Still", "4.90");
        addMenuItemToCategory(softDrinks, "Vio Sprudel 0.2L", "Vio Sprudel", "2.90");
        addMenuItemToCategory(softDrinks, "Vio Sprudel 0.7L", "Vio Sprudel", "4.90");

        addMenuItemToCategory(softDrinks, "O-Saft (Klindworth)", "Orangensaft", "3.90");
        addMenuItemToCategory(softDrinks, "O-Saft-Schorle (Klindworth)", "Orangensaft-Schorle", "3.90");
        addMenuItemToCategory(softDrinks, "Apfelsaft (Klindworth)", "Apfelsaft", "3.90");
        addMenuItemToCategory(softDrinks, "Apfelsaft-Schorle (Klindworth)", "Apfelsaft-Schorle", "3.90");
        addMenuItemToCategory(softDrinks, "Mango (Klindworth)", "Mangosaft", "3.90");
        addMenuItemToCategory(softDrinks, "Mango-Schorle (Klindworth)", "Mango-Schorle", "3.90");
        addMenuItemToCategory(softDrinks, "Maracuja (Klindworth)", "Maracujasaft", "3.90");
        addMenuItemToCategory(softDrinks, "Maracuja-Schorle (Klindworth)", "Maracuja-Schorle", "3.90");

        System.out.println("helloo");
        categoryRepository.save(softDrinks);
    }

    private void seedLemonadesAndIcedTea() {
        Category lemonades = categoryRepository.findCategoryByName("Lemonades");
        addMenuItemToCategory(lemonades, "Granatapfel-Minze", "Granatapfelsirup · frischer Limettensaft · Minzblätter · Soda Water", "3.90");
        addMenuItemToCategory(lemonades, "Minze-Holunder", "Holunderblütensirup · frischer Limettensaft · Minzblätter · Soda Water", "3.90");
        addMenuItemToCategory(lemonades, "Blaubeer", "Blaubeersirup · frischer Zitronensaft · Soda Water", "3.90");
        addMenuItemToCategory(lemonades, "Apfel-Rhababer", "Apfelsaft · Rhabarbersirup · frischer Zitronensaft · Soda Water", "3.90");
        addMenuItemToCategory(lemonades, "Zitrone", "frischer Zitronensaft · Zuckersirup · Soda Water", "3.90");
        addMenuItemToCategory(lemonades, "Fruity Lemo", "Mangopüree · Maracujapüree · frischer Limettensaft · Soda Water", "3.90");
        addMenuItemToCategory(lemonades, "Tropical Lemo", "Mangopüree · Ananassaft · Maracujapüree · Limettensaft · Soda Water", "3.90");
        addMenuItemToCategory(lemonades, "Mango Homemade", "Mangopüree · Limettensaft · Sprudelwasser", "3.90");
        categoryRepository.save(lemonades);

        Category icedTea = categoryRepository.findCategoryByName("Iced Tea");
        addMenuItemToCategory(icedTea, "Cucumber Lime", "green tea · lime juice · sugar syrup · cucumber slices", "3.90");
        addMenuItemToCategory(icedTea, "Mango Passion", "black tea · mango purée · passion fruit purée · lime juice", "3.90");
        addMenuItemToCategory(icedTea, "Peach Orange", "black tea · peach syrup · orange juice · lemon juice", "3.90");
        categoryRepository.save(icedTea);
    }

    private void seedSparklingAndWine() {
        Category sparkling = categoryRepository.findCategoryByName("Sparkling & Aperitif");
        addMenuItemToCategory(sparkling, "Crémant Rosé 0.1L", "Crémant Rosé", "5.90");
        addMenuItemToCategory(sparkling, "Crémant Rosé 0.7L", "Crémant Rosé", "36.90");
        addMenuItemToCategory(sparkling, "Sekt 0.1L", "Sekt", "7.90");
        addMenuItemToCategory(sparkling, "Aperol Spritz", "Aperol Spritz", "7.90");
        addMenuItemToCategory(sparkling, "Limoncello Spritz", "Limoncello Spritz", "7.90");
        addMenuItemToCategory(sparkling, "Lillet Wildberry", "Lillet Wildberry", "7.90");
        addMenuItemToCategory(sparkling, "Pornstar Spritz", "Pornstar Spritz", "8.50");
        addMenuItemToCategory(sparkling, "Campari Spritz", "Campari Spritz", "7.90");
        addMenuItemToCategory(sparkling, "Moet Brut", "Moet Brut", "87.90");
        addMenuItemToCategory(sparkling, "Moet Ice", "Moet Ice", "96.90");
        categoryRepository.save(sparkling);

        Category wine = categoryRepository.findCategoryByName("Wine");
        addMenuItemToCategory(wine, "Grauburgunder 0.2L", "White wine", "6.90");
        addMenuItemToCategory(wine, "Grauburgunder 0.75L", "White wine", "19.90");
        addMenuItemToCategory(wine, "Metzger Riesling 0.2L", "White wine", "6.90");
        addMenuItemToCategory(wine, "Metzger Riesling 0.7L", "White wine", "19.90");
        addMenuItemToCategory(wine, "Sauvignon Blanc 0.2L", "White wine", "6.90");
        addMenuItemToCategory(wine, "Sauvignon Blanc 0.7L", "White wine", "23.90");
        addMenuItemToCategory(wine, "Belrose Mediterranee Rose 0.2L", "Rosé wine", "8.90");
        addMenuItemToCategory(wine, "Belrose Mediterranee Rose 0.75L", "Rosé wine", "24.90");
        addMenuItemToCategory(wine, "Louis Franvin 0.2L", "Red wine", "4.90");
        addMenuItemToCategory(wine, "Louis Franvin 0.75L", "Red wine", "14.90");
        addMenuItemToCategory(wine, "Penfold Koonunga Hill Shiraz 0.2L", "Red wine", "7.90");
        addMenuItemToCategory(wine, "Penfold Koonunga Hill Shiraz 0.75L", "Red wine", "31.90");
        categoryRepository.save(wine);
    }

    private void seedBeer() {
        Category beer = categoryRepository.findCategoryByName("Beer");
        addMenuItemToCategory(beer, "Pils: Königpilsner 0.3L", "On tap", "3.90");
        addMenuItemToCategory(beer, "Pils: Königpilsner 0.5L", "On tap", "4.90");
        addMenuItemToCategory(beer, "Helles: Weihenstephan 0.3L", "On tap", "3.90");
        addMenuItemToCategory(beer, "Helles: Weihenstephan 0.5L", "On tap", "4.90");
        addMenuItemToCategory(beer, "Weizenbier Flasche: Weihenstephan 0.5L", "Bottled", "4.90");
        addMenuItemToCategory(beer, "Weizen Alkoholfrei 0.5L", "Bottled", "4.90");
        addMenuItemToCategory(beer, "Desperados", "Bottled", "5.90");
        addMenuItemToCategory(beer, "KöPi Alkoholfrei", "Bottled", "3.90");
        categoryRepository.save(beer);
    }

    private void seedCocktails() {
        Category caribbean = categoryRepository.findCategoryByName("Caribbean & Fancy");
        addMenuItemToCategory(caribbean, "Mojito", "Havana Club 3 · Rohrzucker · Limette · Minzblätter · Soda Water · Crushed-Eis", "10.90");
        addMenuItemToCategory(caribbean, "Mango Mojito", "Havana Club 3 · Mangopüree · Rohrzucker · Limette · Minzblätter · Soda Water · Crushed-Eis", "10.90");
        addMenuItemToCategory(caribbean, "Caipirinha", "Cachaça · Limette · Rohrzucker · Crushed-Eis", "10.90");
        addMenuItemToCategory(caribbean, "Piña Colada", "Weißer Rum · Kokoscreme · Sahne · Ananassaft · Crushed-Eis", "10.90");
        addMenuItemToCategory(caribbean, "Sex on the Beach", "Vodka · Pfirsichlikör · Grenadine · Orangensaft · Cranberrysaft · Crushed-Eis", "10.90");
        addMenuItemToCategory(caribbean, "Gin Basil Smash", "Gin · Zuckersirup · Frischer Zitronensaft · Frische Basilikumblätter", "10.90");
        addMenuItemToCategory(caribbean, "Swimming Pool", "Vodka · Weißer Rum · Blue Curaçao · Kokoscreme · Ananassaft · Crushed-Eis", "10.90");
        categoryRepository.save(caribbean);

        Category modern = categoryRepository.findCategoryByName("Modern Classics");
        addMenuItemToCategory(modern, "Margarita", "Tequila Blanco · Cointreau (Triple Sec) · Frischer Limettensaft", "10.90");
        addMenuItemToCategory(modern, "Espresso Martini", "Vodka · Kaffeelikör · Frischer Espresso · Zuckersirup", "10.90");
        addMenuItemToCategory(modern, "Pornstar Martini", "Vodka · Passoã · Licor 43 · Vanillesirup · Maracujapüree · Prosecco (Shot)", "11.90");
        addMenuItemToCategory(modern, "Old Fashioned", "Bourbon Whiskey · Zuckersirup · Angostura Bitters", "10.90");
        addMenuItemToCategory(modern, "Negroni", "Gin · Campari · Martini Rosso", "10.90");
        categoryRepository.save(modern);

        Category sours = categoryRepository.findCategoryByName("Sours & Fizzes");
        addMenuItemToCategory(sours, "Whiskey Sour", "Bourbon Whiskey · Zuckersirup · Frischer Zitronensaft · Angostura Bitters", "10.90");
        addMenuItemToCategory(sours, "Aperol Sour", "Aperol · Zuckersirup · Frischer Zitronensaft · Orangensaft", "9.90");
        addMenuItemToCategory(sours, "Gin Fizz", "Gin · Zuckersirup · Frischer Zitronensaft · Soda Water", "9.90");
        categoryRepository.save(sours);

        Category alcoholFree = categoryRepository.findCategoryByName("Alcohol-free cocktails");
        addMenuItemToCategory(alcoholFree, "Virgin Mojito", "Rohrzucker · Limette · Minzblätter · Ginger Ale · Crushed-Eis", "7.90");
        addMenuItemToCategory(alcoholFree, "Virgin Colada", "Kokoscreme · Kokossirup · Ananassaft · Crushed-Eis", "7.90");
        addMenuItemToCategory(alcoholFree, "Cool Mango", "Mangopüree · Orangensaft · Frischer Limettensaft · Frische Minze", "7.90");
        categoryRepository.save(alcoholFree);
    }

    private void seedSpiritsAndHotDrinks() {
        Category spirits = categoryRepository.findCategoryByName("Spirits");
        addMenuItemToCategory(spirits, "Havana Club 3", "Rum 4cl", "4.90");
        addMenuItemToCategory(spirits, "Jack Daniel's", "Whisky 4cl", "6.90");
        addMenuItemToCategory(spirits, "Grey Goose", "Vodka 4cl", "7.90");
        addMenuItemToCategory(spirits, "Tequila Silver", "Tequila 2cl", "2.90");
        addMenuItemToCategory(spirits, "Monkey 47", "Gin 4cl", "8.90");
        addMenuItemToCategory(spirits, "Baileys", "Likör 2cl", "2.90");
        categoryRepository.save(spirits);

        Category hotDrinks = categoryRepository.findCategoryByName("Hot drinks");
        addMenuItemToCategory(hotDrinks, "Espresso / Espresso doppelt", "Hot drink", "2.90");
        addMenuItemToCategory(hotDrinks, "Cappuccino", "Hot drink", "4.90");
        addMenuItemToCategory(hotDrinks, "Latte Macchiato / Milchkaffee", "Hot drink", "4.90");
        addMenuItemToCategory(hotDrinks, "Heiße Schokolade", "Hot drink", "4.90");
        addMenuItemToCategory(hotDrinks, "Teesorten", "Fresh tea with mint, ginger, lemon", "3.90");
        categoryRepository.save(hotDrinks);
    }

    private void seedFood() {
        Category sides = categoryRepository.findCategoryByName("Sides");
        addMenuItemToCategory(sides, "Nachos", "Tortilla-Nachos, heiße Cheddar-Käsesauce", "4.90");
        addMenuItemToCategory(sides, "Nachos Upgrade", "Tortilla-Nachos, heiße Cheddar-Käsesauce, rote Zwiebeln, Jalapeños", "6.90");
        addMenuItemToCategory(sides, "Cole Slaw", "Hausgemachter Krautsalat", "2.90");
        addMenuItemToCategory(sides, "Kleiner Beilagensalat", "Blattsalat, Gurke, Tomaten, Mais, Oliven, rote Zwiebeln", "4.90");
        categoryRepository.save(sides);

        Category snacks = categoryRepository.findCategoryByName("Snacks");
        addMenuItemToCategory(snacks, "Schinken-Käse-Toast", "Schinken, Mozzarella", "4.90");
        addMenuItemToCategory(snacks, "Hertz Snack Spezial", "Rinderhackfleisch, Mozzarella, gebratene Paprika, Champignons", "6.90");
        categoryRepository.save(snacks);

        Category croques = categoryRepository.findCategoryByName("Croques");
        addMenuItemToCategory(croques, "Crispy Chicken", "Paniertes Hähnchen, Chesterkäse, Tomaten, Jalapeños, Eisbergsalat/Krautsalat", "11.90");
        addMenuItemToCategory(croques, "Spicy Chicken", "Würzig paniertes Hähnchen, Edamer, Tomaten, Eisbergsalat/Krautsalat", "11.90");
        addMenuItemToCategory(croques, "Spezial Chicken", "Paniertes Hähnchen, Salami, Chesterkäse, Jalapeños", "12.90");
        addMenuItemToCategory(croques, "Pute Bacon", "Putenbrust, Bacon, Edamer, Tomaten", "10.90");
        addMenuItemToCategory(croques, "Frikadelle", "Frikadelle, Edamer, Tomatensauce, Tomaten", "10.90");
        addMenuItemToCategory(croques, "Meat Bombe", "(Zutaten fehlen noch)", "14.90");
        addMenuItemToCategory(croques, "Tomatenwurst", "Gebratene Wurst, Tomatensauce, Edamer, Tomaten", "10.90");
        addMenuItemToCategory(croques, "Kräuter-Omelett", "Kräuter-Omelett, Gewürzgurken, Tomaten", "11.90");
        addMenuItemToCategory(croques, "Cheese Paradise", "(Zutaten fehlen noch)", "11.90");
        categoryRepository.save(croques);

        Category burger = categoryRepository.findCategoryByName("Burger");
        addMenuItemToCategory(burger, "Cheeseburger", "Angus-Patty, 3x Chesterkäse, Mozzarella, Mais, Oliven", "16.90");
        addMenuItemToCategory(burger, "Mushroom Burger", "Angus-Patty, Chesterkäse, Mozzarella, Champignons, Mais, Oliven", "17.90");
        addMenuItemToCategory(burger, "Chicken Burger", "Paniertes Hähnchen, Chesterkäse, Mozzarella, Jalapeños, Mais, Oliven", "16.90");
        addMenuItemToCategory(burger, "Bacon Burger", "Angus-Patty, Bacon, Chesterkäse, Mozzarella, Röstzwiebeln, Mais, Oliven", "17.90");
        addMenuItemToCategory(burger, "Spezial Burger", "Wagyu-Patty, Chesterkäse, Mozzarella, Champignons, Mais, Oliven", "26.90");
        categoryRepository.save(burger);

        Category salate = categoryRepository.findCategoryByName("Salate");
        addMenuItemToCategory(salate, "Caesar Salat", "Gegrillte Hähnchenbrust, Romana-Salat, Cherrytomaten, Croutons, Grana Padano, Caesar-Dressing", "13.90");
        addMenuItemToCategory(salate, "Salade Niçoise", "Thunfisch, gekochtes Ei, Blattsalat, Gurke, Tomaten, rote Zwiebeln, Kapern, Mais, Oliven", "12.90");
        addMenuItemToCategory(salate, "Vendôme Salat", "Ziegenkäse, Blattsalat, Walnüsse, Tomaten, Gurke, rote Zwiebeln, Oliven", "12.90");
        addMenuItemToCategory(salate, "Schafskäse Salat", "Schafskäse, Blattsalat, Tomaten, Gurke, Mais, Oliven, rote Zwiebeln", "12.90");
        addMenuItemToCategory(salate, "Gemischter Salat", "Blattsalat, Tomaten, Gurke, Mais, Oliven, rote Zwiebeln", "10.90");
        addMenuItemToCategory(salate, "Chef Salat", "Paniertes Hähnchen, Schafskäse, Blattsalat, Tomaten, Gurke, Mais, Oliven, rote Zwiebeln", "13.90");
        categoryRepository.save(salate);

        Category dessert = categoryRepository.findCategoryByName("Dessert");
        addMenuItemToCategory(dessert, "Cheesecake", "Cheesecake, Vanilleeis", "6.90");
        addMenuItemToCategory(dessert, "Schoko Soufflé", "Schokoladen-Soufflé, Vanilleeis", "6.90");
        addMenuItemToCategory(dessert, "Banana Dream", "Crêpe, Nutella, Banane", "6.90");
        addMenuItemToCategory(dessert, "Apfelmus", "Apfelmus", "5.90");
        addMenuItemToCategory(dessert, "Zimt & Zucker", "Crêpe mit Zimt und Zucker", "5.90");
        addMenuItemToCategory(dessert, "Dubai Lovers", "Crêpe mit Pistaziencreme", "7.90");
        categoryRepository.save(dessert);

        Category dips = categoryRepository.findCategoryByName("Dips");
        addMenuItemToCategory(dips, "Kräuter", "Kräuterdip", "1.90");
        addMenuItemToCategory(dips, "Knoblauch", "Knoblauchdip", "1.90");
        addMenuItemToCategory(dips, "Chili", "Chilisauce", "1.90");
        addMenuItemToCategory(dips, "Curry Mango", "Curry-Mango-Sauce", "2.50");
        addMenuItemToCategory(dips, "Cheddar", "Warme Cheddar-Käsesauce", "2.50");
        categoryRepository.save(dips);
    }

    private void addMenuItemToCategory(Category category, String nameDe, String nameEn, String price) {
        MenuItem item = new MenuItem(nameDe, nameDe, new BigDecimal(price));
        if (category.getName() == "Snacks") {
            item.setAvailable(false);
        }
        category.addMenuItem(item);
    }
}