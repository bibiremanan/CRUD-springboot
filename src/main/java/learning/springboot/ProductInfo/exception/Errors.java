package learning.springboot.ProductInfo.exception;

import java.util.Date;

public class Errors {
	private Date errorDate;
	private String errorMessage;
	private String errorDetails;
	public Errors(Date errorDate, String errorMessage, String errorDetails) {
		super();
		this.errorDate = errorDate;
		this.errorMessage = errorMessage;
		this.errorDetails = errorDetails;
	}
	public Date getErrorDate() {
		return errorDate;
	}
	public void setErrorDate(Date errorDate) {
		this.errorDate = errorDate;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	
}
