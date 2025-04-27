/* Zach Fizet
 * SNHU CS 300
 * 3/22/2025
 * Milestone One
 */
package Contact_Service;

// creating the Contact class
public class Contact {
	
	private final String contactId; // contact ID should never change - final keyword variable 
	
	// the rest of the variables that will be required of the Contact object
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	
	// builder for the contact object - each variable is given an illegal argument exception that will produce an error when a certain parameter is not met
	// each variable's constraints are created based off the requirements in the rubric
	// this block of code is restricting what is valid as acceptable for our variables
	// IE: none of them can be blank or empty (null) and that whatever is going into those fields cannot be longer than the given length
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		if (contactId == null || contactId.length() > 10)
			throw new IllegalArgumentException("Contact ID cannot be empty and cannot be longer than 10 characters");
		if (firstName == null || firstName.length() > 10)
			throw new IllegalArgumentException("First name cannot be empty and cannot be longer than 10 characters");
		if (lastName == null || lastName.length() > 10)
			throw new IllegalArgumentException("Last name cannot be empty and cannot be longer than 10 characters");
		if (phone == null || !phone.matches("\\d{10}"))
			throw new IllegalArgumentException("Phone number cannot be empty and must be exactly 10 digits");
		if (address == null || address.length() > 30)
			throw new IllegalArgumentException("Address cannot be empty and cannot be longer than 30 characters");
		
		// re-assigns instance variables within the constructor 
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	
	// Setters and Getters (accessor and mutator methods) for the Contact class
	
	
	// this variable should never change, so it doesn't have a mutator
	public String getContactId() {
		return contactId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	// mutator methods follow the given constraints in the rubric and the same rules as the main constructor
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10)
			throw new IllegalArgumentException("First name cannot be empty and cannot be longer than 10 characters");
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10)
			throw new IllegalArgumentException("Last name cannot be empty and cannot be longer than 10 characters");
		this.lastName = lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		if (phone == null || phone.length() > 10)
			throw new IllegalArgumentException("Phone number cannot be empty and must be exactly 10 digits");
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		if (address == null || address.length() > 30)
			throw new IllegalArgumentException("Address cannot be empty and cannot be longer than 30 characters");
		this.address = address;
	}

}
