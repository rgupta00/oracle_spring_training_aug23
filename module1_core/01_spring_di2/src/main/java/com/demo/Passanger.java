package com.demo;

//passanger code is a bad code
//every time i need to change the vehicle i need to change it
//loose coupling and high cohesion

//coupling is more

//Passanger ---> Bike

public class Passanger {
	
	private String name;
	
	private Vehicle vehicle;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void travel() {
		System.out.println("name : "+ name);
		vehicle.move();
	}
}










