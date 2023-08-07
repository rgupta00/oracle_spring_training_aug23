package com.demo;

public class Main {
	
	public static void main(String[] args) {
	
		//pull Passanger is pulling its depdencies..
		//syn become more complicated
		
		//push : rather then passanger is looking for vehicle ....
		//vehicle is pushed to the passange
		
		//adv : 100% loose coupling
		//how will do the push operation? should i do it manually
		//NO: u can use a framework called spring framework : DI
		
		//consisting of "jar" file => collection of .class files
		
		//maven is a build tool : that download jar automatically
		
		Vehicle vehicle=new Bike();
		Passanger passanger=new Passanger();
		
		passanger.setName("ravi");
		
		passanger.setVehicle(vehicle);
		
		
		passanger.travel();
	}

}
