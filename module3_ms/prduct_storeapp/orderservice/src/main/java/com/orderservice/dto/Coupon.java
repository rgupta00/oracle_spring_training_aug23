package com.orderservice.dto;

import java.util.Date;

public class Coupon {
	private int id;
	private String couponCode;
	private int discountPercentage;
	private Date expiredOn;
	
	
	
	
	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coupon(int id, String couponCode, int discountPercentage, Date expiredOn) {
		super();
		this.id = id;
		this.couponCode = couponCode;
		this.discountPercentage = discountPercentage;
		this.expiredOn = expiredOn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public int getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public Date getExpiredOn() {
		return expiredOn;
	}
	public void setExpiredOn(Date expiredOn) {
		this.expiredOn = expiredOn;
	}
	
	
	
}
