package Contact_Service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

// Class for testing ContactService
public class ContactServiceTest {
	
	private ContactService contactService;
	private Contact contact;
	
	@BeforeEach
	void setUp() {
		contactService = new ContactService();
		contact = new Contact("54321", "John", "Adams", "8888888888", "16 Burton Ave");
		contactService.addContact(contact);
	}
	
	@Test
	// tests the add contact method
	void testAddContact() {
		assertEquals(contact, contactService.getContact("54321"));
	}
	
	
	@Test
	// throws an exception if a duplicate ID is added
	void testAddDuplicateContact() {
		assertThrows(IllegalArgumentException.class, () -> contactService.addContact(new Contact("54321", "John", "Doe", "1234567890", "14 Elm St")));
	}
	
	@Test
	// tests that deleting a contact removes the contact ID - retrieves deleted contact and throws an exception
	void testDeleteContact() {
		contactService.deleteContact("54321");
		assertThrows(NoSuchElementException.class, () -> contactService.getContact("54321"));
	}
	
	@Test
	// ensures that all of the different fields we can modify are modifiable and updated correctly
	void testUpdateContactFields() {
		contactService.updateFirstName("54321", "Amy");
		assertEquals("Amy", contactService.getContact("54321").getFirstName());
		
		contactService.updateLastName("54321", "Rogers");
		assertEquals("Rogers", contactService.getContact("54321").getLastName());
		
		contactService.updatePhone("54321", "1234567890");
		assertEquals("1234567890", contactService.getContact("54321").getPhone());
		
		contactService.updateAddress("54321", "28 Days Ln");
		assertEquals("28 Days Ln", contactService.getContact("54321").getAddress());
	}
	
	@Test
	// verifies that trying to update a contact ID that doesn't exist throws an exception
	void testUpdateNonExistentContact() {
	    assertThrows(IllegalArgumentException.class, () -> contactService.updateFirstName("88888", "Adam"));
	}

}
