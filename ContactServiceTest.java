package contactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

	    @Test
	    public void testContactService() {
	        ContactService service = new ContactService();
	        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
	        assertAll(
	        	   ()-> assertTrue(service.addContact(contact)),
	    	       ()-> assertFalse(service.addContact(contact)),
	    	       ()-> assertTrue(service.updateContact("1", "Joe", "Down", "0987654321", "321 Main Pl")),
	    	       ()-> assertTrue(service.deleteContact("1")),
	    	       ()-> assertFalse(service.deleteContact("2"))
	        		);
	    
	    }
	    
	    
}
