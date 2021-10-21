package com.productcart.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity(name = "ForeignKeyAssoCartProductEntity")
@Table(name = "EcomCart")
public class EcomCart {
	
	public EcomCart() {
		super();
		this.id = 0;
		this.username = null;
		//this.productCat = null;
		this.userId =0;
	}
	
	/*
	 * public EcomCart(String username,List<ProductCart> productCat, int userId) {
	 * super(); this.username = username; this.productCat = productCat; this.userId
	 * =userId; }
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="userId")
	private int userId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

	/*
	 * public List<ProductCart> getProductCat() { return productCat; }
	 * 
	 * public void setProductCat(List<ProductCart> productCat) { this.productCat =
	 * productCat; }
	 */

}
