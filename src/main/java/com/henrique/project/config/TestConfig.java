package com.henrique.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.henrique.project.entities.Category;
import com.henrique.project.entities.Order;
import com.henrique.project.entities.OrderItem;
import com.henrique.project.entities.Payment;
import com.henrique.project.entities.Product;
import com.henrique.project.entities.User;
import com.henrique.project.entities.enums.OrderStatus;
import com.henrique.project.repositories.CategoryRepository;
import com.henrique.project.repositories.OrderItemRepository;
import com.henrique.project.repositories.OrderRepository;
import com.henrique.project.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User seed1 = new User(null, "Jonathan", "Jonathan@gmail.com", "41999991111", "12345");
		User seed2 = new User(null, "Bruna", "Bruna@gmail.com", "41999992222", "678910");
		
		Order seed3 = new Order(null, Instant.parse("2023-12-08T19:53:07Z"), OrderStatus.PAID,seed1);
		Order seed4 = new Order(null, Instant.parse("2023-12-08T16:46:22Z"), OrderStatus.WAITING_PAYAMENT,seed1);
		Order seed5 = new Order(null, Instant.parse("2023-11-08T17:22:17Z"), OrderStatus.DELIVERED,seed2);
		
		userRepository.saveAll(Arrays.asList(seed1, seed2));
		orderRepository.saveAll(Arrays.asList(seed3, seed4, seed5));
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Furniture");
		Category cat3 = new Category(null, "Decoration");
		
		Product seed6 = new Product(null, "Lamp", "Good lamp", 90.5, "");
		Product seed7 = new Product(null, "Pc dell", "Dell notebook 4GB Ram", 799.9, "");
		Product seed8 = new Product(null, "Paint", "Good decoration for yout room", 20.5, "");
		Product seed9 = new Product(null, "Bed", "Minimalist bed, black", 200.0, "");
		Product seed10 = new Product(null, "Samsung S20", "Samsung S series phone", 480.8, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(seed6, seed7, seed8, seed9, seed10));
		
		seed6.getCategories().add(cat2);
		seed6.getCategories().add(cat3);
		seed7.getCategories().add(cat1);
		seed8.getCategories().add(cat3);
		seed9.getCategories().add(cat2);
		seed9.getCategories().add(cat3);
		seed10.getCategories().add(cat1);
		
		productRepository.saveAll(Arrays.asList(seed6, seed7, seed8, seed9, seed10));
		
		OrderItem seed11 = new OrderItem(2, seed6.getPrice(), seed3, seed6);
		OrderItem seed12 = new OrderItem(1, seed8.getPrice(), seed3, seed8);
		OrderItem seed13 = new OrderItem(1, seed7.getPrice(), seed4, seed7);
		OrderItem seed14 = new OrderItem(1, seed10.getPrice(), seed4, seed10);
		OrderItem seed15 = new OrderItem(1, seed9.getPrice(), seed5, seed9);
		
		orderItemRepository.saveAll(Arrays.asList(seed11, seed12, seed13, seed14, seed15));
		
		Payment pay1 = new Payment(null, Instant.parse("2023-12-08T21:53:07Z"), seed3);
		seed3.setPayment(pay1);
		
		orderRepository.save(seed3);
	}
}
