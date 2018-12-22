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
public class P2PResponse {

	String requestId;
	String status;
	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}
	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "P2PResponse [requestId=" + requestId + ", status=" + status + "]";
	}
	
	
	
}
