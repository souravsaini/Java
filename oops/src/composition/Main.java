package composition;

public class Main {

	public static void main(String[] args) {
		Wall wall1 = new Wall("North");
		Wall wall2 = new Wall("East");
		Wall wall3 = new Wall("South");
		Wall wall4 = new Wall("West");
		Ceiling ceiling = new Ceiling(12, 60);
		Bed bed = new Bed("Queen", 4, 3, 2, 1);
		Lamp lamp = new Lamp("Modern", false, 4);
		
		Bedroom bedroom = new Bedroom("Room", wall1, wall2, wall3, wall4, ceiling, bed, lamp);
		bedroom.makeBed();
		bedroom.getLamp().turnOn();
	}

}
