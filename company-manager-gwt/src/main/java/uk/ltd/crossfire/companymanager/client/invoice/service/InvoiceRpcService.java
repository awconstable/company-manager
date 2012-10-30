package uk.ltd.crossfire.companymanager.client.invoice.service;

import java.util.List;

import uk.ltd.crossfire.companymanager.common.domain.Invoice;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("invoice")
public interface InvoiceRpcService extends RemoteService {

	Invoice getInvoice(int id);

	List<Invoice> getInvoices(int start, int length);

	Integer getInvoiceCount();

}
