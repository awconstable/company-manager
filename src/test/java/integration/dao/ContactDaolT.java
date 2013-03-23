package integration.dao;

import integration.AbstractDaoIT;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import uk.ltd.crossfire.companymanager.server.dao.ContactDao;
import uk.ltd.crossfire.companymanager.server.persistence.InvoiceMapper;
import uk.ltd.crossfire.companymanager.server.requests.InvoiceMapperRequest;
import uk.ltd.crossfire.companymanager.shared.entities.Contact;
import uk.ltd.crossfire.companymanager.shared.entities.Invoice;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ContactDaolT extends AbstractDaoIT {

	@Autowired
	private ContactDao dao;

	@Test
	public void testGetContact() {
		Contact contact = dao.getContact(1);

		System.out.print(contact.toString());

		assertEquals(1, contact.getId());
	}

	@Test
	public void testGetContacts() {
		List<Contact> contacts = dao.getContacts();

		assertTrue(contacts.size() > 1);
	}

}
