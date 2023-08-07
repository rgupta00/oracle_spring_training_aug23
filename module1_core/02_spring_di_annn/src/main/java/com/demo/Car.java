package com.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//<bean id="v2" class="com.demo.Car"/>
@Component(value = "v2")
@Primary
public class Car implements Vehicle{
	public void move() {
		System.out.println("moving in a car");
	}
}
