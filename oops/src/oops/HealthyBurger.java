package oops;

public class HealthyBurger extends Hamburger {
	private String extraName1;
	private double extraPrice1;
	private String extraName2;
	private double extraPrice2;
	public HealthyBurger(String meat, double price) {
		super("Healthy", meat, price, "Brown Rye");	
	}
	
	public void addAddition1(String name, double price) {
		this.extraName1 = name;
		this.extraPrice1 = price;
	}
	
	public void addAddition2(String name, double price) {
		this.extraName2 = name;
		this.extraPrice2 = price;
	}

	@Override
	public double getTotalPrice() {
		double price = super.getTotalPrice();
		
		if(this.extraName1 != null) price += this.extraPrice1;
		if(this.extraName2 != null) price += this.extraPrice2;
		
		return price;
	}
	
	
}
