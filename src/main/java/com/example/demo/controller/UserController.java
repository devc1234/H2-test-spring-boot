package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repo.UserRepo;
import com.example.demo.entity.User;


@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserRepo userRepo;
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User user){
		
		userRepo.save(user);
		
		return new ResponseEntity<String>("user saved sucessfully", HttpStatus.OK);
	}
	
	
	@GetMapping(value = "{id}")
	public ResponseEntity<?> getuser(@PathVariable Long id){
		Optional<User>persisetobj=userRepo.findById(id);
		return new ResponseEntity<User>(persisetobj.orElseThrow(),HttpStatus.OK);
	}

}
