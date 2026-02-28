package com.order.service.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.service.DTO.UserResponse;

@FeignClient(name = "user-service")
public interface UserClient {

	@GetMapping("api/v1/user/getuserbyid/{id}")
	public UserResponse getUserByIdController(@PathVariable("id") int id);
}
