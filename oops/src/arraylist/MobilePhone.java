package arraylist;

import java.util.ArrayList;

public class MobilePhone {
	private ArrayList<Contact> contacts;

	public MobilePhone() {
		super();
		this.contacts = new ArrayList<>();
	}
	
	public boolean addContact(Contact contact) {
		if(findContact(contact.getName()) >= 0) {
			System.out.println("Contact already exists");
			return false;
		}
		contacts.add(contact);
		return true;
	}
	
	private int findContact(Contact contact) {
		return this.contacts.indexOf(contact);
	}
	
	private int findContact(String name) {
		for(int i=0; i<this.contacts.size(); i++) {
			Contact contact = this.contacts.get(i);
			if(contact.getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public String queryContact(Contact contact) {
		if(findContact(contact) >= 0) {
			return contact.getName();
		}
		return null;
	}
	
	public Contact queryContact(String name) {
		int pos = findContact(name);
		if(pos >= 0) return this.contacts.get(pos); 
		else return null;
	}
	
	public boolean deleteContact(Contact contact) {
		int pos = findContact(contact);
		if(pos < 0) {
			System.out.println("Contact not found");
			return false;
		}
		this.contacts.remove(pos);
		return true;
	}
	
	public boolean updateContact(Contact oldContact, Contact newContact) {
		int pos = findContact(oldContact);
		if(pos < 0) {
			System.out.println("Contact not found");
			return false;
		}
		this.contacts.set(pos, newContact);
		return true;
	}
	
	public void printContacts() {
		for(Contact contact: this.contacts) {
			System.out.println(contact.getName() + " - " + contact.getPhone());
		}
	}
}
