package uk.ltd.crossfire.companymanager.server.service;

import java.util.List;

import uk.ltd.crossfire.companymanager.common.domain.Invoice;

public interface InvoiceService {

	Invoice getInvoice(int id);

	List<Invoice> getInvoices(int start, int length);

	Integer getInvoiceCount();

}
