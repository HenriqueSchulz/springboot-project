package com.henrique.project.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.henrique.project.entities.User;

@RestController
@RequestMapping(value = "/users", method = RequestMethod.GET)
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		
		User u = new User(1L, "maria", "maria@gmail.com", "91999954545", "1234");
		return ResponseEntity.ok().body(u);
	}
}
