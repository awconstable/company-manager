package uk.ltd.crossfire.companymanager.server.persistence;

import java.util.List;

import uk.ltd.crossfire.companymanager.common.domain.Invoice;
import uk.ltd.crossfire.companymanager.server.requests.InvoiceMapperRequest;

public interface InvoiceMapper {

	Invoice getInvoice(int id);

	List<Invoice> getInvoices(InvoiceMapperRequest request);

	Integer getInvoiceCount();

}
