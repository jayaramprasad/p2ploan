/**
 * 
 */
package com.p2ploan.app.model;

import org.springframework.stereotype.Component;

/**
 * @author jayaram
 *
 */
@Component
public class P2PExceptionResponse {

	String errorCode;
	String errorMessage;
	String errorDescription;
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the errorDescription
	 */
	public String getErrorDescription() {
		return errorDescription;
	}
	/**
	 * @param errorDescription the errorDescription to set
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "P2PExceptionResponse [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", errorDescription="
				+ errorDescription + "]";
	}
	
	
	
	
	
}
