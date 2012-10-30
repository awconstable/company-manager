package uk.ltd.crossfire.companymanager.server.requests;

public class InvoiceMapperRequest {

	private int start;
	private int length;

	public InvoiceMapperRequest(int start, int length) {
		this.start = start;
		this.length = length;
	}

	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

}
