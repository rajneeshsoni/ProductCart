package com.productcart.api.model;

import java.util.List;

public class CartRequest {
	
	private List<ProductCartData> cartList;

	public List<ProductCartData> getCartList() {
		return cartList;
	}

	public void setCartList(List<ProductCartData> cartList) {
		this.cartList = cartList;
	}

	

}
