package uk.ltd.crossfire.companymanager.shared.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Invoice implements Serializable {

	private static final long serialVersionUID = -8620723232194943168L;

	private int id;

	private int docNumber;
	private Date dateIssued;
	private Date dateCompleted;
	private boolean cancelled;
	private boolean completed;
	private double netValue;
	private double vatValue;
	private double totalValue;
	private double shippingValue;
	private String clientRef;
	private double vatRate;
	private String comment;
	private Date dateCancelled;

	private int contactId;
	private String accountRef;
	private String companyName;
	private String address1;
	private String address2;
	private String city;
	private String postcode;
	private String country;
	private String vatNumber;

    private Set<InvoiceRow> rows = new HashSet<InvoiceRow>();

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(int docNumber) {
		this.docNumber = docNumber;
	}

	public Date getDateIssued() {
		return dateIssued;
	}

	public void setDateIssued(Date dateIssued) {
		this.dateIssued = dateIssued;
	}

	public Date getDateCompleted() {
		return dateCompleted;
	}

	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public double getNetValue() {
		return netValue;
	}

	public void setNetValue(double netValue) {
		this.netValue = netValue;
	}

	public double getVatValue() {
		return vatValue;
	}

	public void setVatValue(double vatValue) {
		this.vatValue = vatValue;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public double getShippingValue() {
		return shippingValue;
	}

	public void setShippingValue(double shippingValue) {
		this.shippingValue = shippingValue;
	}

	public String getClientRef() {
		return clientRef;
	}

	public void setClientRef(String clientRef) {
		this.clientRef = clientRef;
	}

	public double getVatRate() {
		return vatRate;
	}

	public void setVatRate(double vatRate) {
		this.vatRate = vatRate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDateCancelled() {
		return dateCancelled;
	}

	public void setDateCancelled(Date dateCancelled) {
		this.dateCancelled = dateCancelled;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getAccountRef() {
		return accountRef;
	}

	public void setAccountRef(String accountRef) {
		this.accountRef = accountRef;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

    public Set<InvoiceRow> getRows() {
        return rows;
    }

    public void setRows(Set<InvoiceRow> rows) {
        this.rows = rows;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Invoice [id=").append(id).append(", docNumber=")
				.append(docNumber).append(", dateIssued=").append(dateIssued)
				.append(", dateCompleted=").append(dateCompleted)
				.append(", cancelled=").append(cancelled)
				.append(", completed=").append(completed).append(", netValue=")
				.append(netValue).append(", vatValue=").append(vatValue)
				.append(", totalValue=").append(totalValue)
				.append(", shippingValue=").append(shippingValue)
				.append(", clientRef=").append(clientRef)
				.append(", vatRate=").append(vatRate).append(", comment=")
				.append(comment).append(", dateCancelled=")
				.append(dateCancelled).append(", contactId=").append(contactId)
				.append(", accountRef=").append(accountRef)
				.append(", companyName=").append(companyName)
				.append(", address1=").append(address1).append(", address2=")
				.append(address2).append(", city=").append(city)
				.append(", postcode=").append(postcode).append(", country=")
				.append(country).append(", vatNumber=").append(vatNumber)
				.append("]");
		return builder.toString();
	}

}
