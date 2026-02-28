package com.user.service.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	// SLF4J Logger (manual, no Lombok)
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	IUserServices userService;

	@PostMapping("create-user")
	public ResponseEntity<String> createUserController(@RequestBody UserDTO userdto) {

		// API entry log
        log.info("Create User API called");

        // Debug log (safe fields only)
        log.debug("Create User request payload: {}", userdto);

		String response = userService.createUserService(userdto);
		
		// Success log
        log.info("User created successfully");

		return ResponseEntity.ok(response);
	}

	@GetMapping("getuserbyid/{id}")
	public ResponseEntity<UserEntity> getUserByIdController(@PathVariable("id") int id) {

		  // API entry log
        log.info("Get User By ID API called with id={}", id);

        Optional<UserEntity> response = userService.getUserByID(id);

        if (response.isPresent()) {
            log.info("User found with id={}", id);
            return ResponseEntity.ok(response.get());
        } else {
            log.warn("User not found with id={}", id);
            return ResponseEntity.notFound().build();
        }
	}
}
