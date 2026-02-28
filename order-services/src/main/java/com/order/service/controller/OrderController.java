package com.order.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.service.DTO.OrderDTO;
import com.order.service.services.IOrderService;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

	// SLF4J Logger (manual, no Lombok)
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	IOrderService orderService;

	// CREATE ORDER
	@PostMapping("create-Order")
	public String createOrder(@RequestBody OrderDTO request) {
		// API entry log
		log.info("Create Order API called");

		// Debug log (safe business fields only)
		log.debug("Create Order request received: userId={}, amount={}", request.getUserId(), request.getAmount());
		
		String response = orderService.createOrder(request);

        // Success log
        log.info("Order created successfully");

        return response;
	}
}
