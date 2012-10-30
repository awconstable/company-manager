package uk.ltd.crossfire.companymanager.client.invoicelist;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class InvoiceListActivity extends AbstractActivity implements InvoiceListView.Presenter {

	private final InvoiceListView view;
	private final PlaceController placeController;

	@Inject
	public InvoiceListActivity(InvoiceListView view, PlaceController placeController) {
		this.view = view;
		this.placeController = placeController;
	}

	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus) {
		view.setPresenter(this);

		container.setWidget(view.asWidget());
	}

	@Override
	public void goTo(Place place) {
		placeController.goTo(place);
	}

	public InvoiceListActivity withPlace(InvoiceListPlace place) {
		return this;
	}

}
