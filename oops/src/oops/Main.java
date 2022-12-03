package oops;

public class Main {

	public static void main(String[] args) {
		Hamburger ham = new Hamburger("Basic", "Sausage", 3.6, "White");
		double price = ham.getTotalPrice();
		
		ham.addHambugerAddition("Tomato", 0.3);
		ham.addHambugerAddition("Lettuce", 0.25);
		ham.addHambugerAddition("Mushroom", 0.65);
		
		price = ham.getTotalPrice();
		System.out.println("Total: " + price);
	}

}
