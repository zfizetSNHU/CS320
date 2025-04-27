package Contact_Service;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

// For this class, we're creating a map that will view and/or change details about an object based off of its contactId
// Each method retrieves the contactId from the Contact class and uses that as a reference to access the rest of the variables tied to that contact ID
// Note: each method will check to ensure the contact ID exists, producing the error "contact ID not found" if it doesn't exist
class ContactService {
	private final Map<String, Contact> contacts = new HashMap<>();
	
	
	// method to add a contact - contains error handling for duplicate IDs
	public void addContact(Contact contact) {
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact ID already exists.");
		}
		
		contacts.put(contact.getContactId(), contact); // adds the new contact 
	}
	
	// method to delete contact 
	public void deleteContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new NoSuchElementException("Contact ID not found.");
		}
		
		contacts.remove(contactId); // removes the contact ID
	}
	
	// method for retrieving contact information
	public Contact getContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new NoSuchElementException("Contact not found.");
		}
		return contacts.get(contactId);
	}
	
	// method for updating first name
	public void updateFirstName(String contactId, String firstName) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID not found.");
		}
		
		contacts.get(contactId).setFirstName(firstName); // updates first name
	}
	
	// method for updating last name 
	public void updateLastName(String contactId, String lastName) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID not found.");
		}
		
		contacts.get(contactId).setLastName(lastName); // updates last name
	}
	// method for updating phone number
	public void updatePhone(String contactId, String phone) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID not found.");
		}
		
		contacts.get(contactId).setPhone(phone); // updates phone number
	}
	
	// method for updating address 
	public void updateAddress(String contactId, String address) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID not found.");
		}
		
		contacts.get(contactId).setAddress(address); // updates the address
	}

}
