package com.productcart.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productcart.api.model.ProductCart;



@Repository
public interface ProductRepository extends JpaRepository<ProductCart, Integer>{

	
	  List<ProductCart> findByUsername(String username);
	  
	  void deleteByUsername(String username);
	
	
	

}