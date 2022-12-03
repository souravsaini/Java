package oops;

import java.util.ArrayList;

public class Hamburger {
	private String name;
	private String meat;
	private double price;
	private String breadType;
	
	private ArrayList<Addition> additions;
	
	
	public Hamburger(String name, String meat, double price, String breadType) {
		super();
		this.name = name;
		this.meat = meat;
		this.price = price;
		this.breadType = breadType;
		this.additions = new ArrayList<>();
	}
	
	public void addHambugerAddition(String name, double price) {
		Addition addition = new Addition(name, price);
		additions.add(addition);
	}
	
	public double getTotalPrice() {
		double hamPrice = this.price;
		System.out.println(this.name + " hamburger on a " + this.breadType + " roll. Price is " + this.price);
		
		for(Addition addition: additions) {
			hamPrice += addition.getPrice();
			System.out.println("Added "+ addition.getName() + " for an extra " + addition.getPrice());
		}
		return hamPrice;
	}
	
	
}
