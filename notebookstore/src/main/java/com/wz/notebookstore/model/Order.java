package com.wz.notebookstore.model;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
	
	private int order_id;
	private int order_user_id; 
	private int order_cover_id; 
	private int order_style_id; 
	private String order_date;
	private double order_price;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getOrder_user_id() {
		return order_user_id;
	}
	public void setOrder_user_id(int order_user_id) {
		this.order_user_id = order_user_id;
	}
	public int getOrder_cover_id() {
		return order_cover_id;
	}
	public void setOrder_cover_id(int order_cover_id) {
		this.order_cover_id = order_cover_id;
	}
	public int getOrder_style_id() {
		return order_style_id;
	}
	public void setOrder_style_id(int order_style_id) {
		this.order_style_id = order_style_id;
	}
	public double getOrder_price() {
		return order_price;
	}
	public void setOrder_price(double order_price) {
		this.order_price = order_price;
	}
	
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	
	public Order(int order_id, int order_user_id, int order_cover_id,
			int order_style_id, String order_date, double order_price) {
		super();
		this.order_id = order_id;
		this.order_user_id = order_user_id;
		this.order_cover_id = order_cover_id;
		this.order_style_id = order_style_id;
		this.order_date = order_date;
		this.order_price = order_price;
	}
	public Order() {
		super();
	}
	
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_user_id=" + order_user_id + ", order_cover_id=" + order_cover_id
				+ ", order_style_id=" + order_style_id + ", order_date=" + order_date + ", order_price=" + order_price
				+ "]";
	} 
	
}
