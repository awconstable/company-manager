package uk.ltd.crossfire.companymanager.server.dao;

import uk.ltd.crossfire.companymanager.server.requests.InvoiceMapperRequest;
import uk.ltd.crossfire.companymanager.shared.entities.Invoice;

import java.util.List;

public interface InvoiceDao {

    Invoice getInvoice(int id);

    List<Invoice> getInvoices();

    List<Invoice> getInvoices(InvoiceMapperRequest request);

    Integer getInvoiceCount();

}
