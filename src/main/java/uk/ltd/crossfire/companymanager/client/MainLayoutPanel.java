package uk.ltd.crossfire.companymanager.client;

import uk.ltd.crossfire.companymanager.client.invoice.service.InvoiceRpcServiceAsync;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.inject.Inject;

public class MainLayoutPanel extends FlowPanel {

	@Inject
	public MainLayoutPanel(final InvoiceRpcServiceAsync invoiceService, final Messages messages) {


	}

}
