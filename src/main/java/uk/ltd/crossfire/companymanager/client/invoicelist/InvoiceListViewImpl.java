package uk.ltd.crossfire.companymanager.client.invoicelist;

import java.util.Date;

import uk.ltd.crossfire.companymanager.client.invoicelist.providers.InvoiceDataProvider;
import uk.ltd.crossfire.companymanager.shared.entities.Invoice;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.inject.Inject;

public class InvoiceListViewImpl extends Composite implements InvoiceListView {

	private final InvoiceDataProvider provider;

	private final FlowPanel container = new FlowPanel();

	@Inject
	public InvoiceListViewImpl(InvoiceDataProvider provider) {
		this.provider = provider;
		configureWidget();
		initWidget(container);
	}

	private void configureWidget() {
		  CellTable<Invoice> table = new CellTable<Invoice>();
	  	  table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
	  	  table.setPageSize(20);

	  	  provider.addDataDisplay(table);

	  	  SimplePager pager = new SimplePager();
	  	  pager.setDisplay(table);

	  	  TextColumn<Invoice> invoiceNumberColumn = new TextColumn<Invoice>() {
	  	      @Override
	  	      public String getValue(Invoice object) {
	  	        return Integer.toString(object.getDocNumber());
	  	      }
	  	    };
	  	    table.addColumn(invoiceNumberColumn, "Invoice Number");

	    	TextColumn<Invoice> accountRefColumn = new TextColumn<Invoice>() {
	      	   @Override
	      	   public String getValue(Invoice object) {
	      	     return object.getAccountRef();
	      	   }
	      	 };
	      	table.addColumn(accountRefColumn, "Account Ref");

	  	    TextColumn<Invoice> refColumn = new TextColumn<Invoice>() {
	      	      @Override
	      	      public String getValue(Invoice object) {
	      	        return object.getClientRef();
	      	      }
	      	    };
	      	table.addColumn(refColumn, "Client Ref");

	      	DateCell dateCell = new DateCell(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT));
	          Column<Invoice, Date> dateColumn = new Column<Invoice, Date>(dateCell) {
	            @Override
	            public Date getValue(Invoice object) {
	              return object.getDateIssued();
	            }
	          };
	          table.addColumn(dateColumn, "Issue Date");

	      	NumberCell numberCell = new NumberCell(NumberFormat.getCurrencyFormat("GBP"));
	          Column<Invoice, Number> netAmountColumn = new Column<Invoice, Number>(numberCell) {
	            @Override
	            public Number getValue(Invoice object) {
	              return object.getNetValue();
	            }
	          };
	          netAmountColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
	          table.addColumn(netAmountColumn, "Net Amount");

	          Column<Invoice, Number> vatAmountColumn = new Column<Invoice, Number>(numberCell) {
	            @Override
	            public Number getValue(Invoice object) {
	              return object.getVatValue();
	            }
	          };
	          vatAmountColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
	          table.addColumn(vatAmountColumn, "VAT Amount");

	          Column<Invoice, Number> totalAmountColumn = new Column<Invoice, Number>(numberCell) {
		              @Override
		              public Number getValue(Invoice object) {
		                return object.getTotalValue();
		          }
		        };
		        totalAmountColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		        table.addColumn(totalAmountColumn, "Total Amount");

	  	    final SingleSelectionModel<Invoice> selectionModel = new SingleSelectionModel<Invoice>();
	  	    table.setSelectionModel(selectionModel);
	  	    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
	  	      @Override
				public void onSelectionChange(SelectionChangeEvent event) {
	  	    	  Invoice selected = selectionModel.getSelectedObject();
	  	        if (selected != null) {
	  	          Window.alert("You selected: " + selected.getDocNumber());
	  	        }
	  	      }
	  	    });

	  	  container.add(pager);
	  	container.add(table);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		// TODO Auto-generated method stub

	}

}
