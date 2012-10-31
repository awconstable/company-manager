package uk.ltd.crossfire.companymanager.server.exceptions;

public class CompanyManagerSystemException extends Exception {

	private static final long serialVersionUID = -560334207623755240L;

	public CompanyManagerSystemException() {
	}

	public CompanyManagerSystemException(String message) {
		super(message);
	}

	public CompanyManagerSystemException(Throwable cause) {
		super(cause);
	}

	public CompanyManagerSystemException(String message, Throwable cause) {
		super(message, cause);
	}

}
