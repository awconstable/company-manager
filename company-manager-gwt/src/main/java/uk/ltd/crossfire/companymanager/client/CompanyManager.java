package uk.ltd.crossfire.companymanager.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CompanyManager implements EntryPoint {

  private final RootGinInjector injector = GWT.create(RootGinInjector.class);

  /**
   * This is the entry point method.
   */
  @Override
  public void onModuleLoad() {

	  PlaceHistoryHandler historyHandler = injector.getHistoryHandler();

      RootPanel.get().add(injector.getRootWidget());

      historyHandler.handleCurrentHistory();
  }
}