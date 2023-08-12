package com.henrique.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.henrique.project.entities.Order;
import com.henrique.project.entities.User;
import com.henrique.project.repositories.OrderRepository;
import com.henrique.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User seed1 = new User(null, "Jonathan", "Jonathan@gmail.com", "41999991111", "12345");
		User seed2 = new User(null, "Bruna", "Bruna@gmail.com", "41999992222", "678910");
		
		Order seed3 = new Order(null, Instant.parse("2023-12-08T19:53:07Z"), seed1);
		Order seed4 = new Order(null, Instant.parse("2023-12-08T16:46:22Z"), seed1);
		Order seed5 = new Order(null, Instant.parse("2023-11-08T17:22:17Z"), seed2);
		
		userRepository.saveAll(Arrays.asList(seed1, seed2));
		orderRepository.saveAll(Arrays.asList(seed3, seed4, seed5));
		
	}
}
