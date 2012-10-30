package uk.ltd.crossfire.companymanager.client;

import uk.ltd.crossfire.companymanager.client.invoicelist.InvoiceListActivity;
import uk.ltd.crossfire.companymanager.client.invoicelist.InvoiceListPlace;
import uk.ltd.crossfire.companymanager.client.invoicelist.InvoiceListView;
import uk.ltd.crossfire.companymanager.client.invoicelist.InvoiceListViewImpl;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;

public class RootGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);

		bind(PlaceHistoryMapper.class).to(AppPlaceHistoryMapper.class).in(Singleton.class);

		bind(ActivityMapper.class).to(AppActivityMapper.class).in(Singleton.class);

		bind(SimplePanel.class).in(Singleton.class);

		bind(InvoiceListView.class).to(InvoiceListViewImpl.class).in(Singleton.class);
		bind(InvoiceListActivity.class);
	}

	@Provides
	@Singleton
	public PlaceHistoryHandler getHistoryHandler(PlaceController placeController,
	                                                                     PlaceHistoryMapper historyMapper,
	                                                                     EventBus eventBus,
	                                                                     ActivityManager activityManager) {
	    PlaceHistoryHandler historyHandler =  new PlaceHistoryHandler(historyMapper);
	    historyHandler.register(placeController, eventBus, new InvoiceListPlace());
	    return historyHandler;
	  }

	  @Provides
	  @Singleton
	  public PlaceController getPlaceController(EventBus eventBus) {
	    return new PlaceController(eventBus);
	  }

	  @Provides
	  @Singleton
	  public ActivityManager getActivityManager(ActivityMapper mapper,
	                                                                 EventBus eventBus,
	                                                                 SimplePanel display) {
	    ActivityManager activityManager = new ActivityManager(mapper, eventBus);
	    activityManager.setDisplay(display);
	    return activityManager;
	  }

}
