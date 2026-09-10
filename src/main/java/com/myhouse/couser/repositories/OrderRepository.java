package com.myhouse.couser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myhouse.couser.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	

}
