package uk.ltd.crossfire.companymanager.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import uk.ltd.crossfire.companymanager.client.invoice.service.InvoiceRpcService;
import uk.ltd.crossfire.companymanager.shared.entities.Invoice;
import uk.ltd.crossfire.companymanager.server.service.InvoiceService;

@SuppressWarnings("serial")
public class InvoiceRpcServiceImpl extends AutoWiredRpcService implements InvoiceRpcService {

	@Autowired
	private InvoiceService service;

	@Override
	public Invoice getInvoice(int id) {
		return service.getInvoice(id);
	}

	@Override
	public List<Invoice> getInvoices(int start, int length) {
		return service.getInvoices(start, length);
	}

	@Override
	public Integer getInvoiceCount() {
		return service.getInvoiceCount();
	}

}
