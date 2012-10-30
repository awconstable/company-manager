package uk.ltd.crossfire.companymanager.client.invoicelist.providers;

import java.util.List;

import uk.ltd.crossfire.companymanager.client.invoice.service.InvoiceRpcServiceAsync;
import uk.ltd.crossfire.companymanager.common.domain.Invoice;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.Range;
import com.google.inject.Inject;

public class InvoiceDataProvider extends AsyncDataProvider<Invoice> {

	private final InvoiceRpcServiceAsync invoiceService;

	@Inject
	public InvoiceDataProvider(final InvoiceRpcServiceAsync invoiceService) {
		this.invoiceService = invoiceService;
	}

	/**
     * {@link #onRangeChanged(HasData)} is called when the table requests a new
     * range of data. You can push data back to the displays using
     * {@link #updateRowData(int, List)}.
     */
    @Override
    protected void onRangeChanged(HasData<Invoice> display) {

      final Range range = display.getVisibleRange();
      final int start = range.getStart();

      invoiceService.getInvoiceCount(new AsyncCallback<Integer>() {
          @Override
		public void onFailure(Throwable caught) {
        	  Window.alert("RPC error");
          }

          @Override
		public void onSuccess(Integer result) {
        	  updateRowCount(result, true);
          }
      });

      invoiceService.getInvoices(start, range.getLength(), new AsyncCallback<List<Invoice>>() {
          @Override
		public void onFailure(Throwable caught) {
        	  Window.alert("RPC error");
          }

          @Override
		public void onSuccess(List<Invoice> result) {
        	  updateRowData(start, result);
          }
      });

    }
  }