package com.henrique.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.henrique.project.entities.Category;
import com.henrique.project.entities.Order;
import com.henrique.project.entities.User;
import com.henrique.project.entities.enums.OrderStatus;
import com.henrique.project.repositories.CategoryRepository;
import com.henrique.project.repositories.OrderRepository;
import com.henrique.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category seed6 = new Category(null, "Eletronics");
		Category seed7 = new Category(null, "Furniture");
		Category seed8 = new Category(null, "Decoration");
		
		User seed1 = new User(null, "Jonathan", "Jonathan@gmail.com", "41999991111", "12345");
		User seed2 = new User(null, "Bruna", "Bruna@gmail.com", "41999992222", "678910");
		
		Order seed3 = new Order(null, Instant.parse("2023-12-08T19:53:07Z"), OrderStatus.PAID,seed1);
		Order seed4 = new Order(null, Instant.parse("2023-12-08T16:46:22Z"), OrderStatus.WAITING_PAYAMENT,seed1);
		Order seed5 = new Order(null, Instant.parse("2023-11-08T17:22:17Z"), OrderStatus.DELIVERED,seed2);
		
		
		userRepository.saveAll(Arrays.asList(seed1, seed2));
		orderRepository.saveAll(Arrays.asList(seed3, seed4, seed5));
		categoryRepository.saveAll(Arrays.asList(seed6, seed7, seed8));
		
	}
}
