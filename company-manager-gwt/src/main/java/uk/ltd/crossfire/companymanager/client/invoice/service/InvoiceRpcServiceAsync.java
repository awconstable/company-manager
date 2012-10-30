package uk.ltd.crossfire.companymanager.client.invoice.service;

import java.util.List;

import uk.ltd.crossfire.companymanager.common.domain.Invoice;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface InvoiceRpcServiceAsync {

	void getInvoice(int id, AsyncCallback<Invoice> callback);

	void getInvoices(int start, int length, AsyncCallback<List<Invoice>> callback);

	void getInvoiceCount(AsyncCallback<Integer> callback);

}
