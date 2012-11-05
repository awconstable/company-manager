package integration.persistence;

import static org.junit.Assert.assertEquals;
import integration.AbstractDaoIT;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import uk.ltd.crossfire.companymanager.shared.entities.Invoice;
import uk.ltd.crossfire.companymanager.server.persistence.InvoiceMapper;
import uk.ltd.crossfire.companymanager.server.requests.InvoiceMapperRequest;

public class InvoiceMapperlT extends AbstractDaoIT {

	@Autowired
	private InvoiceMapper dao;

	@Test
	public void testGetInvoice() {
		Invoice invoice = dao.getInvoice(35);

		System.out.print(invoice.toString());

		assertEquals(35, invoice.getId());
	}

	@Test
	public void testGetInvoices() {
		List<Invoice> invoices = dao.getInvoices(new InvoiceMapperRequest(0, 10));

		assertEquals(10, invoices.size());
	}

}
