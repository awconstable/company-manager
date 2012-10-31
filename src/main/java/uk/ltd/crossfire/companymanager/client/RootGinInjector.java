package uk.ltd.crossfire.companymanager.client;

import uk.ltd.crossfire.companymanager.client.invoicelist.InvoiceListActivity;
import uk.ltd.crossfire.companymanager.client.invoicelist.InvoiceListView;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.SimplePanel;

@GinModules(RootGinModule.class)
public interface RootGinInjector extends Ginjector {

	EventBus getEventBus();

	PlaceHistoryHandler getHistoryHandler();

	PlaceController getPlaceController();

	ActivityManager getActivityManager();

	SimplePanel getRootWidget();

	InvoiceListView getInvoiceListView();

	InvoiceListActivity getInvoiceListActivity();

}
