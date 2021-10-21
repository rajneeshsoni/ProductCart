package com.productcart.api.model;

import javax.persistence.Column;



public class ProductCartData {
	
	 
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
	
	

}
