package com.productcart.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.productcart.api.model.EcomCart;

public interface ProductCartRepo extends JpaRepository<EcomCart, String>{
	
	//@Query("SELECT id FROM EcomCart c WHERE c.username = ?1")
	EcomCart findByUsername(String username);
	
	 void deleteByUsername(String username);

	void deleteById(Integer cartId);

}
