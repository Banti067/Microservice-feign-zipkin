package com.order.service.services;

import org.springframework.stereotype.Service;

import com.order.service.DTO.OrderDTO;

@Service
public interface IOrderService {

	public String createOrder(OrderDTO orderdto);

	  // public String getOrderById(Long id);
}
