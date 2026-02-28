package com.order.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.service.enity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

}
