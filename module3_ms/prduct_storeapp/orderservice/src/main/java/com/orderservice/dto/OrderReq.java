package com.orderservice.dto;

public class OrderReq {
	private int productId;
	private int customerId;
	private String couponCode;
	private int qty;
	
	public OrderReq(int productId, int customerId, String couponCode, int qty) {
		super();
		this.productId = productId;
		this.customerId = customerId;
		this.couponCode = couponCode;
		this.qty = qty;
	}
	public OrderReq() {}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "OrderReq [productId=" + productId + ", customerId=" + customerId + ", couponCode=" + couponCode
				+ ", qty=" + qty + "]";
	}
	
	
	
}
