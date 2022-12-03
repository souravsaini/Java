package inheritance;

public class Vehicle {
	private String name;
	private String size;
	
	private int currentVelocity;
	private int currentDirection;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getCurrentVelocity() {
		return currentVelocity;
	}

	public void setCurrentVelocity(int currentVelocity) {
		this.currentVelocity = currentVelocity;
	}

	public int getCurrentDirection() {
		return currentDirection;
	}

	public void setCurrentDirection(int currentDirection) {
		this.currentDirection = currentDirection;
	}

	public Vehicle(String name, String size) {
		super();
		this.name = name;
		this.size = size;
		this.currentVelocity = 0;
		this.currentDirection = 0;
	}
	
	public void steer(int direction) {
		this.currentDirection += direction;
		System.out.println("Vehicle steering at " + this.currentDirection);
	}
	
	public void move(int velocity, int direction) {
		this.currentVelocity = velocity;
		this.currentDirection = direction;
		System.out.println("Vehicle moving at " + this.currentVelocity + " in direction " + this.currentDirection);
	}
	
	public void stop() {
		this.currentVelocity = 0;
	}
}
