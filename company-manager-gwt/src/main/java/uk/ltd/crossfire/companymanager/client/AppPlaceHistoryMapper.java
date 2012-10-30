package uk.ltd.crossfire.companymanager.client;

import uk.ltd.crossfire.companymanager.client.invoicelist.InvoiceListPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({InvoiceListPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper
{

}
