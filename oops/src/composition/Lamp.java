package composition;

public class Lamp {
	private String style;
	private boolean battery;
	private int rating;
	public Lamp(String style, boolean battery, int rating) {
		super();
		this.style = style;
		this.battery = battery;
		this.rating = rating;
	}
	public String getStyle() {
		return style;
	}
	public boolean isBattery() {
		return battery;
	}
	public int getRating() {
		return rating;
	}
	
	public void turnOn() {
		System.out.println("Lamp -> Turning ON");
	}
}
