package com.henrique.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henrique.project.entities.User;
import com.henrique.project.repositories.UserRepository;
import com.henrique.project.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user =  userRepository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insertUser(User user) {
		return userRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	public User updateUser(Long id, User user) {
		User userUpdated = userRepository.getReferenceById(id);
		updateData(userUpdated, user);
		return userRepository.save(userUpdated);
	}

	private void updateData(User userUpdated, User user) {
		userUpdated.setName(user.getName());
		userUpdated.setEmail(user.getEmail());
		userUpdated.setPhone(user.getPhone());
	}
}
