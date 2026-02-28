package com.user.service.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.user.service.DTO.UserDTO;
import com.user.service.entity.UserEntity;

@Service
public interface IUserServices {

	public String createUserService(UserDTO userdto);
	
	public Optional<UserEntity> getUserByID(int id);
}
