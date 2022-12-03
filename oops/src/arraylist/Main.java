package arraylist;

import java.util.Scanner;

public class Main {
	private static Scanner scan = new Scanner(System.in);
	private static MobilePhone mobilePhone = new MobilePhone();
	
	public static void main(String[] args) {
		boolean quit = false;
		printActions();
		while(!quit) {
			int action = scan.nextInt();
			switch(action) {
			case 0:
				System.out.println("Exiting");
				break;
			
			case 1:
				mobilePhone.printContacts();
				break;
				
			case 2:
				addContact();
				break;
				
			case 3:
				updateContact();
				break;
				
			case 4:
				deleteContact();
				break;
				
			case 5:
				queryContact();
				break;
			}
		}
		
	}

	private static void addContact() {
		System.out.println("Enter contact name");
		String name = scan.next();
		System.out.println("Enter phone number");
		String phone = scan.next();
		Contact contact = Contact.createContact(name, phone);
		if(mobilePhone.addContact(contact)) {
			System.out.println("Contact added");
		} else {
			System.out.println("Contact could't be added");
		}
	}
	
	private static void deleteContact() {
		System.out.println("Enter existing contact name");
		String e_name = scan.next();
		Contact existing = mobilePhone.queryContact(e_name);
		if(existing == null) {
			System.out.println("Contact not found");
			return;
		}
		
		if(mobilePhone.deleteContact(existing)) {
			System.out.println("Contact updated");
		} else {
			System.out.println("Couldn't delete contact");
		}
	}
	
	private static void queryContact() {
		System.out.println("Enter existing contact name");
		String e_name = scan.next();
		Contact existing = mobilePhone.queryContact(e_name);
		if(existing == null) {
			System.out.println("Contact not found");
			return;
		}
		
		System.out.println(existing.getName() + " - " + existing.getPhone());
		
	}
	
	
	
	private static void updateContact() {
		System.out.println("Enter existing contact name");
		String e_name = scan.next();
		Contact existing = mobilePhone.queryContact(e_name);
		if(existing == null) {
			System.out.println("Contact not found");
			return;
		}
		System.out.println("Enter new contact name");
		String name = scan.next();
		System.out.println("Enter new phone number");
		String phone = scan.next();
		Contact newContact = Contact.createContact(name, phone);
		if(mobilePhone.updateContact(newContact, newContact)) {
			System.out.println("Contact updated");
		} else {
			System.out.println("Couldn't update contact");
		}
	}
	
	private static void printActions() {
		System.out.println("0 - Exit");
		System.out.println("1 - Print contacts");
		System.out.println("2 - Add contact");
		System.out.println("3 - Update contact");
		System.out.println("4 - Delete contact");
		System.out.println("5 - Find contact");
		System.out.println("Enter your choice: ");
	}

}
