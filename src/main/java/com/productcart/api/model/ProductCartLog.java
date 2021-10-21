package com.productcart.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProductCartLog implements Serializable{
	String service;
	String operation;
	String info;
	Date date;
	List<ProductCart> listOfProduct;
	
	public ProductCartLog(String service, String operation, String info, List<ProductCart> listOfProduct,Date date) {
		super();
		this.service = service;
		this.operation = operation;
		this.info = info;
		this.date = date;
		this.listOfProduct=listOfProduct;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<ProductCart> getListOfProduct() {
		return listOfProduct;
	}
	public void setListOfProduct(List<ProductCart> listOfProduct) {
		this.listOfProduct = listOfProduct;
	}

}
