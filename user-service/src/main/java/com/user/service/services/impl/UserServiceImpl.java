package com.user.service.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.DTO.UserDTO;
import com.user.service.entity.UserEntity;
import com.user.service.repository.UserRepository;
import com.user.service.services.IUserServices;

@Service
public class UserServiceImpl implements IUserServices{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public String createUserService(UserDTO userdto) {
		
		UserEntity userEntity = new UserEntity();
		userEntity.setName(userdto.getName());
		userEntity.setEmail(userdto.getEmail());
		
		UserEntity response = userRepository.save(userEntity);
		
		return "User Registered Successfully: "+ response;
	}

	@Override
	public Optional<UserEntity> getUserByID(int id) {
 
		Optional<UserEntity> userId = userRepository.findById(id);
		
	    return  userId;
	}

	
}
