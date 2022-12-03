package interfaces;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> values = new ArrayList<>();
		

	}
	
	public static void save(Savable object) {
		for(int i=0; i<object.write().size(); i++) {
			System.out.println("Saving " + object.write().get(i) + " to storage");
		}
	}
}
