package com.hertzecke.HertzEcke_Backend.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private MenuItem menuItem;

    @Column(nullable = false)
    private int amount;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    public OrderItem() {

    }

    public OrderItem(Order order, MenuItem menuItem, int amount) {
        this.order = order;
        this.menuItem = menuItem;
        this.amount = amount;
    }
}
