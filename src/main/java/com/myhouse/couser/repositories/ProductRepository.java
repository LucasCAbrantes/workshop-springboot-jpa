package com.myhouse.couser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myhouse.couser.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	

}
