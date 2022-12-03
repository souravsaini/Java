package oops;

public class DeluxeBurger extends Hamburger {
	public DeluxeBurger() {
		super("Deluxe", "Sausage & Bacon", 13.5, "White");
		super.addHambugerAddition("Chips", 2.75);
		super.addHambugerAddition("Drinks", 7.75);
	}

	@Override
	public void addHambugerAddition(String name, double price) {
		System.out.println("Cannot add additional items to deluxe burger");
	}
}
