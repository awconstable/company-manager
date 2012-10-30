package uk.ltd.crossfire.companymanager.client;

import uk.ltd.crossfire.companymanager.client.invoicelist.InvoiceListActivity;
import uk.ltd.crossfire.companymanager.client.invoicelist.InvoiceListPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class AppActivityMapper implements ActivityMapper {

	private final Provider<InvoiceListActivity> invoiceListActivityProvider;

	@Inject
	public AppActivityMapper(final Provider<InvoiceListActivity> invoiceListActivityProvider) {
		super();
		this.invoiceListActivityProvider = invoiceListActivityProvider;
	}

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof InvoiceListPlace) {
            return invoiceListActivityProvider.get().withPlace((InvoiceListPlace) place);
        } else {
        	return null;
        }
    }

}
