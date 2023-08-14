package com.henrique.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henrique.project.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
