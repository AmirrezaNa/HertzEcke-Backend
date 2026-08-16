package com.hertzecke.HertzEcke_Backend.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@Entity
@Table(name = "menu_items")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nameDe;

    private String nameEn;

    private String descriptionDe;
    private String descriptionEn;
    private String size;
    private String imageUrl;
    private boolean available = true;


    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public MenuItem() {

    }

    public MenuItem(String nameDe, String nameEn, BigDecimal price) {
        this.nameDe = nameDe;
        this.nameEn = nameEn;
        this.price = price;
    }
}
