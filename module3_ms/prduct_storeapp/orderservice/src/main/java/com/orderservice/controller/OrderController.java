package com.orderservice.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.orderservice.dto.Coupon;
import com.orderservice.dto.Customer;
import com.orderservice.dto.OrderReq;
import com.orderservice.dto.OrderResponse;
import com.orderservice.dto.Product;

@RestController
public class OrderController {
	
	private RestTemplate restTemplate;

	@Autowired
	public OrderController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@PostMapping(path = "orders")
	public OrderResponse registerOrder(@RequestBody  OrderReq orderReq) {
		OrderResponse orderResponse=new OrderResponse();
		int productId=orderReq.getProductId();
		int customerId=orderReq.getCustomerId();
		String couponCode=orderReq.getCouponCode();
		int qty=orderReq.getQty();
		
		
		
		//i need to call the product rest api to get the product details
		
		Product product=restTemplate
				.getForObject("http://PRODUCTAPP-SERVICE/productapp/products/"+productId, Product.class);
		
		//i need to call customer rest api to get the customer details
		Customer customer=restTemplate
				.getForObject("http://CUSTOMERAPP-SERVICE/customerapp/customers/"+customerId, Customer.class);
		
		//i need to call coupon rest api to get coupon details
		Coupon coupon=restTemplate.getForObject("http://COUPONAPP-SERVICE/couponapp/coupons/"+couponCode, Coupon.class);
		
		orderResponse.setCustomer(customer);
		orderResponse.setProduct(product);
		orderResponse.setOrderDate(new Date());
		orderResponse.setId(123);
		//10% discount on total price 200
		//
		//double discountedPrice=(product.getPrice()-product.getPrice()*coupon.getDiscountPercentage())/100;
		
		double totalPrice=qty*product.getPrice();
		
		orderResponse.setTotalPrice(totalPrice);
		//finally i will create the order object and return back to the client
		
		
		return orderResponse;
	}

}












