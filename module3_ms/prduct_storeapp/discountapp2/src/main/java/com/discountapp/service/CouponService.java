package com.discountapp.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.discountapp.dto.Coupon;

@Service
public class CouponService {

	//use db to get the actual coupon object
	public Coupon getCoupon(String couponCode) {
		Coupon coupon=null;
		if(couponCode.equals("SUPER10"))
			coupon=new Coupon(1, couponCode, 10, new Date());
		else if(couponCode.equals("SUPER20"))
			coupon=new Coupon(1, couponCode, 20, new Date());
		else if(couponCode.equals("SUPER30"))
			coupon=new Coupon(1, couponCode, 30, new Date());
		else 
			coupon=new Coupon(1, couponCode, 5, new Date());
		
		return coupon;
	}
}
