package com.user.service.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.DTO.UserDTO;
import com.user.service.entity.UserEntity;
import com.user.service.services.IUserServices;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
	
	@Autowired
	IUserServices userService;

	@PostMapping("create-user")
	public ResponseEntity<String> createUserController(@RequestBody UserDTO  userdto) {
		
		System.out.println("UserController.createUserController()");
		
		String response = userService.createUserService(userdto);
		
		return ResponseEntity.ok(response); 
	}
	
	@GetMapping("getuserbyid/{id}")
	public Optional<UserEntity> getUserByIdController(@PathVariable("id") int id){
		
		Optional<UserEntity> response = userService.getUserByID(id);
		return response;
	}
}
