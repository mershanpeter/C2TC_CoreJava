package com.tnsif.dayeight.interfaces.functionalinterfaces;

public class anonomousclass {
	public static void main(String args[]) {
		GreetClass g = new GreetClass();
		System.out.println(g.greet());
		g.display();
		
		GreetInterface g1 = new GreetClass();
		System.out.println(g1.greet());
		g1.display();
		
		//anonymous class
		GreetInterface g2 = (GreetInterface) new GreetInterface() {
			@Override
			public String greet() {
				return "Welcome to the world of Java";
		}
			
			@Override
			public void display() {
				System.out.println("display method");
			}
		};

}
