package arraylist;

public class Contact {
	private String name;
	private String phone;
	public Contact(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	
	public static Contact createContact(String name, String phone) {
		return new Contact(name,  phone);
	}
}
