package com.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//<bean id="v1" class="com.demo.Bike" primary="true"/>
@Component(value = "v1")
public class Bike implements Vehicle{
	public void move() {
		System.out.println("moving on a bike");
	}
}
