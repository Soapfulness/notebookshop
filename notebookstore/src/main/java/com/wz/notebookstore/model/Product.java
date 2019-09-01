package com.wz.notebookstore.model;

import java.io.Serializable;

//VO类
public class Product implements Serializable  {
	
	private Integer id; //商品ID
	private String product;  //商品类别
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer productId) {
		this.id = productId;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}

}
