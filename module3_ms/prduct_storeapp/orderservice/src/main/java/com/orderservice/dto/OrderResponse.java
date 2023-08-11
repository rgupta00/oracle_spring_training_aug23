package com.orderservice.dto;

import java.util.Date;

public class OrderResponse {
	private int id;
	private double totalPrice;
	private Date orderDate;
	private Customer customer;
	private Product product;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public OrderResponse(int id, double totalPrice, Date orderDate, Customer customer, Product product) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.customer = customer;
		this.product = product;
	}
	public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
