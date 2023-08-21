package com.henrique.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.henrique.project.entities.User;
import com.henrique.project.repositories.UserRepository;
import com.henrique.project.services.exceptions.DataBaseException;
import com.henrique.project.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		try {	
			if(userRepository.existsById(id)) {		
				userRepository.deleteById(id);
			} else {
				throw new ResourceNotFoundException(id);
			}
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public User updateUser(Long id, User user) {
		try {	
			User userUpdated = userRepository.getReferenceById(id);
			updateData(userUpdated, user);
			return userRepository.save(userUpdated);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User userUpdated, User user) {
		userUpdated.setName(user.getName());
		userUpdated.setEmail(user.getEmail());
		userUpdated.setPhone(user.getPhone());
	}
}
