package contactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	 @Test
	    public void testMakeContact() {
	        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
	        assertAll(
	        		()-> assertEquals("1", contact.getContactId()),
	        		()-> assertEquals("John", contact.getFirstName()),
	        		()-> assertEquals("Doe", contact.getLastName()),
	        		()-> assertEquals("1234567890", contact.getPhone()),
	        		()-> assertEquals("123 Main St", contact.getAddress())
	        		);
	    }

	    @Test
	    public void testContactInvalidID() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
	        });
	    }
	    
	    @Test
		void testContactIDTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class,() -> {
				new Contact("12345678910", "Dathan", "Pompa", "1234569999", "123 First St. Riverside");
			});
		}
	    
	    @Test
		void testContactFirstNameTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class,() -> {
				new Contact("1", "Dathan78910", "Pompa", "1234569999", "123 First St. Riverside");
				});
			}
		@Test
		void testContactFirstNameIsNull() {
			Assertions.assertThrows(IllegalArgumentException.class,() -> {
				new Contact("1", null, "Pompa", "1234569999", "123 First St. Riverside");
				});
		}
		
		@Test
		void testContactLastNameTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class,() -> {
				new Contact("1", "Dathan", "Pompa678910", "1234569999", "123 First St. Riverside");
				});
			}
		@Test
		void testContactLastNameIsNull() {
			Assertions.assertThrows(IllegalArgumentException.class,() -> {
				new Contact("1", "Dathan", null, "1234569999", "123 First St. Riverside");
				});
		}
		
		@Test
		void testContactNumberIsNotTenDigits() {
			Assertions.assertThrows(IllegalArgumentException.class,() -> {
				new Contact("1", "Dathan", "Pompa", "123456789", "123 First St. Riverside");
				});
			}
		@Test
		void testContactNumberIsNull() {
			Assertions.assertThrows(IllegalArgumentException.class,() -> {
				new Contact("1", "Dathan", "Pompa", null, "123 First St. Riverside");
				});
		}
		
		@Test
		void testContactAddressIsTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class,() -> {
				new Contact("1", "Dathan", "Pompa", "1234567899", "0123456789012345678901234567890");
				});
			}
		@Test
		void testContactAddressIsNull() {
			Assertions.assertThrows(IllegalArgumentException.class,() -> {
				new Contact("1", "Dathan", "Pompa", "1234567899", null);
				});
		}
}
