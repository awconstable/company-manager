package uk.ltd.crossfire.companymanager.server;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import uk.ltd.crossfire.companymanager.client.invoice.service.InvoiceRpcService;
import uk.ltd.crossfire.companymanager.server.annotations.BoundryLogger;
import uk.ltd.crossfire.companymanager.shared.entities.Invoice;
import uk.ltd.crossfire.companymanager.server.service.InvoiceService;

@SuppressWarnings("serial")
public class InvoiceRpcServiceImpl extends AutoWiredRpcService implements InvoiceRpcService {

    Logger log = LoggerFactory.getLogger(InvoiceRpcServiceImpl.class);

	@Autowired
	private InvoiceService service;

    @BoundryLogger
	@Override
	public Invoice getInvoice(int id) {
        log.debug("getInvoiceId, id: {}", id);
		return service.getInvoice(id);
	}

    @BoundryLogger
	@Override
	public List<Invoice> getInvoices(int start, int length) {
        log.debug("getInvoices, start: {}, length: {}", start, length);
        List<Invoice> invoices = new ArrayList<Invoice>();
        try{
		 invoices = service.getInvoices(start, length);
        } catch (Exception ex){
            log.error("Could not get invoices", ex);
        }
        return invoices;
	}

    @BoundryLogger
	@Override
	public Integer getInvoiceCount() {
		Integer invoiceCount = service.getInvoiceCount();
        log.debug("getInvoiceCount: {}", invoiceCount);
        return invoiceCount;
	}

}
