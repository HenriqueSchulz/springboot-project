package com.henrique.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henrique.project.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
