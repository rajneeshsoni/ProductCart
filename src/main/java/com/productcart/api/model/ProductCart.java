package com.productcart.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "ForeignKeyAssoCartEntity")
@Table(name = "Productcart")
public class ProductCart {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id")
	 private int id;
	
    @Column(name="productid")
	private int productId;
	
	@Column(name="productname")
	private String productName;
	
	@Column(name="productunit")
	private int productUnit;
	
	@Column(name="productamount")
	private Double productAmount;
	
	@Column(name="username")
	private String username;
	
	@Column(name="cartid")
	private Integer cartId;
		
	@Column(name="userId")
	 private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(int productUnit) {
		this.productUnit = productUnit;
	}

	public Double getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Double productAmount) {
		this.productAmount = productAmount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

}
