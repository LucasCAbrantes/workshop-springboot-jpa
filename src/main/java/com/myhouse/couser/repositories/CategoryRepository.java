package com.myhouse.couser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myhouse.couser.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	

}
