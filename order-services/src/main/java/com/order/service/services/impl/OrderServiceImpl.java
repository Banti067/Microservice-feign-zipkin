package com.order.service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.service.DTO.OrderDTO;
import com.order.service.DTO.UserResponse;
import com.order.service.enity.OrderEntity;
import com.order.service.feignclient.UserClient;
import com.order.service.repository.OrderRepository;
import com.order.service.services.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserClient userClient;

	@Override
	public String createOrder(OrderDTO orderdto) {

		 //  Validate user via Feign
		UserResponse userData = userClient.getUserByIdController(orderdto.getUserId());
		
		OrderEntity orderData = new OrderEntity();
		
		orderData.setOrderNumber(orderdto.getOrderNumber());
		orderData.setUserId(orderdto.getUserId());
		orderData.setAmount(orderdto.getAmount());
		
		OrderEntity response =orderRepository.save(orderData);
		return "Order Created Successfully"+ response;
	}

//	@Override
//	public String getOrderById(Long id) {
//		
//		return null;
//	}
}
