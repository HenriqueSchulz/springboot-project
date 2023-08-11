package com.henrique.project.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.henrique.project.entities.User;
import com.henrique.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User seed1 = new User(null, "Jonathan", "Jonathan@gmail.com", "41999991111", "12345");
		User seed2 = new User(null, "Bruna", "Bruna@gmail.com", "41999992222", "678910");
		
		userRepository.saveAll(Arrays.asList(seed1, seed2));
		
	}
}