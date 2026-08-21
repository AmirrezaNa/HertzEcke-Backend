package com.hertzecke.HertzEcke_Backend.service;

import com.hertzecke.HertzEcke_Backend.dto.OrderDTO;
import com.hertzecke.HertzEcke_Backend.dto.OrderRequestDTO;
import com.hertzecke.HertzEcke_Backend.model.MenuItem;
import com.hertzecke.HertzEcke_Backend.model.Order;
import com.hertzecke.HertzEcke_Backend.model.OrderItem;
import com.hertzecke.HertzEcke_Backend.model.OrderStatus;
import com.hertzecke.HertzEcke_Backend.repository.MenuItemRepository;
import com.hertzecke.HertzEcke_Backend.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final MenuItemRepository menuItemRepository;

    public OrderService(OrderRepository orderRepository, MenuItemRepository menuItemRepository) {
        this.orderRepository = orderRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Transactional
    public OrderDTO createOrder(OrderRequestDTO request) {
        if (request.items() == null || request.items().isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item.");
        }

        Order order = new Order();
        order.setName(request.name());
        order.setPhoneNumber(request.phoneNumber());

        List<OrderItem> orderItems = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        for (OrderRequestDTO.OrderItemRequestDTO itemRequest : request.items()) {
            if (itemRequest.amount() <= 0) {
                throw new IllegalArgumentException("Item amount must be greater than zero.");
            }

            // Look up the real MenuItem from the database — never trust a price from the client.
            MenuItem menuItem = menuItemRepository.findById(itemRequest.menuItemId())
                    .orElseThrow(() -> new NoSuchElementException(
                            "Menu item not found: " + itemRequest.menuItemId()));

            if (!menuItem.isAvailable()) {
                throw new IllegalStateException(
                        "Menu item is not available: " + menuItem.getNameDe());
            }

            OrderItem orderItem = new OrderItem(order, menuItem, itemRequest.amount());
            orderItems.add(orderItem);

            BigDecimal lineTotal = menuItem.getPrice().multiply(BigDecimal.valueOf(itemRequest.amount()));
            total = total.add(lineTotal);
        }

        order.setOrderItems(orderItems);
        order.setTotalPrice(total);
        order.setStatus(OrderStatus.PENDING);

        Order savedOrder = orderRepository.save(order);
        return OrderDTO.orderEntityToDTO(savedOrder);
    }

    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Order not found: " + id));
        return OrderDTO.orderEntityToDTO(order);
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderDTO::orderEntityToDTO)
                .toList();
    }
}
