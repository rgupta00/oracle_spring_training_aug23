package com.discountapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.discountapp.dto.Coupon;
import com.discountapp.service.CouponService;

@RestController
public class CouponController {
	
	private CouponService couponService;
	
	@Autowired
	public CouponController(CouponService couponService) {
		this.couponService = couponService;
	}

	@GetMapping(path = "coupons/{couponCode}")
	public Coupon getCoupon( @PathVariable String couponCode) {
		System.out.println("--------instance 2 is running-------------");
		return couponService.getCoupon(couponCode);
	}

}
