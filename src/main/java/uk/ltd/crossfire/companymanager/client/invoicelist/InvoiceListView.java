package uk.ltd.crossfire.companymanager.client.invoicelist;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface InvoiceListView extends IsWidget {

	void setPresenter(Presenter presenter);

	public interface Presenter {
		void goTo(Place place);
	}
}
