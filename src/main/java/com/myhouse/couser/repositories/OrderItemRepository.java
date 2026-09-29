package com.myhouse.couser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myhouse.couser.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
	

}
