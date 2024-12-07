package com.itschool.jpa.services.impl;

import com.itschool.jpa.enums.OrderStatus;
import com.itschool.jpa.models.Order;
import com.itschool.jpa.models.OrderItem;
import com.itschool.jpa.models.User;
import com.itschool.jpa.repositories.OrderRepository;
import com.itschool.jpa.repositories.UserJpaRepository;
import com.itschool.jpa.services.OrderService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserJpaRepository userRepository;

    /**
     * Places an order for a specific user
     */
    public Order placeOrder(Long userId, List<OrderItem> items) {
        if (items == null || items.isEmpty())
            throw new IllegalArgumentException("Order must contain at least one item!");


        Optional<User> userOpt = userRepository.findById(userId);
        Order order = new Order();
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            order.setUser(user);
            order.setItems(items);
            order.setStatus(OrderStatus.PENDING);
            order.setOrderDate(LocalDate.now());
            order.calculateTotalAmount();
            items.forEach(OrderItem::updateInstrumentStock);
        } else {
            throw new EntityNotFoundException("User was not found!");
        }

        return orderRepository.save(order);
    }

    public List<Order> getOrdersWithPagination(Long userId, int page, int size) {

        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Order> orderPage = orderRepository.findByUserId(userId, pageRequest);
        return orderPage.getContent();
    }
}
