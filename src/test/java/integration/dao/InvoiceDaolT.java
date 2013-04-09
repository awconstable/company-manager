package integration.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import integration.AbstractDaoIT;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import uk.ltd.crossfire.companymanager.server.dao.InvoiceDao;
import uk.ltd.crossfire.companymanager.shared.entities.Invoice;
import uk.ltd.crossfire.companymanager.server.requests.InvoiceMapperRequest;

public class InvoiceDaolT extends AbstractDaoIT {

	@Autowired
	private InvoiceDao dao;

	@Test
	public void testGetInvoice() {
		Invoice invoice = dao.getInvoice(35);

		System.out.print(invoice.toString());

		assertEquals(35, invoice.getId());
	}

    @Test
    public void testGetInvoiceRows() {
        Invoice invoice = dao.getInvoice(35);

        System.out.println(invoice.getRows());

        assertTrue(invoice.getRows().size() > 0);
    }

	@Test
	public void testGetInvoices() {
		List<Invoice> invoices = dao.getInvoices();

		assertTrue(invoices.size() > 0);
	}

    @Test
    public void testGetPageOfInvoices() {
        List<Invoice> invoices = dao.getInvoices(new InvoiceMapperRequest(0, 10));

        assertEquals(10, invoices.size());
    }

}
