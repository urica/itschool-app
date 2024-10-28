package com.itschool.jpa.repositories;

import com.itschool.jpa.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
