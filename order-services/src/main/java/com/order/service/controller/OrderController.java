package com.order.service.controller;

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

	@Autowired
	IOrderService orderService;
	// CREATE ORDER
    @PostMapping("create-Order")
    public String createOrder(@RequestBody OrderDTO request) {
        return orderService.createOrder(request);
    }
}
