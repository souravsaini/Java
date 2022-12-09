package abstractclass;

public class Main {

	public static void main(String[] args) {
		LList list = new LList(null);
		
		String[] cities = {"Darwin", "Brisbane", "Perth", "Sydney", "Melbourne", "Canberra", "Adelaide", "Melbourne", "Adelaide"};
		for(String city: cities) {
			list.addItem(new Node(city));
		}
		
		list.traverse(list.getRoot());
		
		System.out.println("###############");
		
		list.removeItem(new Node("Brisbane"));
		list.removeItem(new Node("Sydney"));
		
		list.traverse(list.getRoot());
	}

}
