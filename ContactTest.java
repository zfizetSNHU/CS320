package Contact_Service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


// class for testing Contact
// Ensures that a Contact object is created correctly
public class ContactTest {
	private Contact contact;
	
	@BeforeEach
	
	void setUp() {
		contact = new Contact("12345", "Jane", "Smith", "9999999999", "42 Wallaby Way");
	}
	
	@Test
	// tests that contact is created correctly and that getters return the expected values
	void testContactCreation() {
		assertEquals("12345", contact.getContactId());
		assertEquals("Jane", contact.getFirstName());
		assertEquals("Smith", contact.getLastName());
		assertEquals("9999999999", contact.getPhone());
		assertEquals("42 Wallaby Way", contact.getAddress());
	}
	
	@Test
	// throws an exception when trying to create a contact with a null ID or an ID longer than 10 characters
	void testInvalidContactId() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Jane", "Smith", "9999999999", "42 Wallaby Way"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "Jane", "Smith", "9999999999", "42 Wallaby Way"));
	}

}
