package com.user.service.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.DTO.UserDTO;
import com.user.service.entity.UserEntity;
import com.user.service.repository.UserRepository;
import com.user.service.services.IUserServices;

@Service
public class UserServiceImpl implements IUserServices {

	// SLF4J Logger (manual)
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public String createUserService(UserDTO userdto) {

		// Business entry log
		log.info("User creation started");

		// Debug log (safe business data)
		log.debug("UserDTO received: name={}, email={}", userdto.getName(), userdto.getEmail());
		UserEntity userEntity = new UserEntity();
		userEntity.setName(userdto.getName());
		userEntity.setEmail(userdto.getEmail());

		// DB operation log
		log.info("Saving user to database");

		UserEntity response = userRepository.save(userEntity);

		// Success log
		log.info("User saved successfully with id={}", response.getId());
		return "User Registered Successfully: " + response;
	}

	@Override
	public Optional<UserEntity> getUserByID(int id) {

		// Business entry log
		log.info("Fetching user from database with id={}", id);

		Optional<UserEntity> userOpt = userRepository.findById(id);

		if (userOpt.isPresent()) {
			log.info("User found with id={}", id);
		} else {
			log.warn("User not found with id={}", id);
		}

		return userOpt;
	}

}
