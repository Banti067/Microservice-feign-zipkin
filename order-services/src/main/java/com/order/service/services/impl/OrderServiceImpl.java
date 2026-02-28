package com.order.service.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	// SLF4J Logger (manual, no Lombok)
	private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserClient userClient;

	@Override
	public String createOrder(OrderDTO orderdto) {
		// ================= BUSINESS ENTRY =================
		log.info("Order creation started");

		// Debug log (safe business fields only)
		log.debug("OrderDTO received: orderNumber={}, userId={}, amount={}", orderdto.getOrderNumber(),
				orderdto.getUserId(), orderdto.getAmount());

		// ================= FEIGN CALL =================
		log.info("Calling User Service via Feign for userId={}", orderdto.getUserId());

		// Validate user via Feign
		UserResponse userData = userClient.getUserByIdController(orderdto.getUserId());

		log.info("User Service responded successfully for userId={}", orderdto.getUserId());

		OrderEntity orderData = new OrderEntity();

		orderData.setOrderNumber(orderdto.getOrderNumber());
		orderData.setUserId(orderdto.getUserId());
		orderData.setAmount(orderdto.getAmount());

		// ================= DB OPERATION =================
		log.info("Saving order to database");

		OrderEntity response = orderRepository.save(orderData);

		log.info("Order saved successfully with orderId={}", response.getId());

		return "Order Created Successfully";
	}

//	@Override
//	public String getOrderById(Long id) {
//		
//		return null;
//	}
}
