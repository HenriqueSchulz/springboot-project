package com.henrique.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henrique.project.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
