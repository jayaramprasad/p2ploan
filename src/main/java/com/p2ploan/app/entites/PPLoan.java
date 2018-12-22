/**
 * 
 */
package com.p2ploan.app.entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jayaram
 *
 */
@Entity
@Table(name="pploan")
public class PPLoan {

	@Id
	@Column(name="id")
	long id;
	@Column(name="request_id")
	String requestId;
	@Column(name="requester_type")
	String requesterType;
	@Column(name="request_amount")
	double requestAmount;
	@Column(name="request_tenure")
	int requestTenure;
	@Column(name="request_interest")
	double requestInterest;
	@Column(name="approved_amount")
	double approvedAmount;
	@Column(name="approved_tenure")
	int approvedTenure;
	@Column(name="approved_interest")
	double approvedInterest;
	@Column(name="borrower_mobile")
	String borrowerMobile;
	@Column(name="lender_mobile")
	String lenderMobile;
	@Column(name="created_by")
	String createdBy;
	@Column(name="created_date")
	Date createdDate;
	@Column(name="comment")
	String comment;
	@Column(name="request_status")
	String requestStatus;
	
	
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
	 * @return the requesterType
	 */
	public String getRequesterType() {
		return requesterType;
	}
	/**
	 * @param requesterType the requesterType to set
	 */
	public void setRequesterType(String requesterType) {
		this.requesterType = requesterType;
	}
	/**
	 * @return the requestAmount
	 */
	public double getRequestAmount() {
		return requestAmount;
	}
	/**
	 * @param requestAmount the requestAmount to set
	 */
	public void setRequestAmount(double requestAmount) {
		this.requestAmount = requestAmount;
	}
	/**
	 * @return the requestTenure
	 */
	public int getRequestTenure() {
		return requestTenure;
	}
	/**
	 * @param requestTenure the requestTenure to set
	 */
	public void setRequestTenure(int requestTenure) {
		this.requestTenure = requestTenure;
	}
	/**
	 * @return the requestInterest
	 */
	public double getRequestInterest() {
		return requestInterest;
	}
	/**
	 * @param requestInterest the requestInterest to set
	 */
	public void setRequestInterest(double requestInterest) {
		this.requestInterest = requestInterest;
	}
	/**
	 * @return the approvedAmount
	 */
	public double getApprovedAmount() {
		return approvedAmount;
	}
	/**
	 * @param approvedAmount the approvedAmount to set
	 */
	public void setApprovedAmount(double approvedAmount) {
		this.approvedAmount = approvedAmount;
	}
	/**
	 * @return the approvedTenure
	 */
	public int getApprovedTenure() {
		return approvedTenure;
	}
	/**
	 * @param approvedTenure the approvedTenure to set
	 */
	public void setApprovedTenure(int approvedTenure) {
		this.approvedTenure = approvedTenure;
	}
	/**
	 * @return the approvedInterest
	 */
	public double getApprovedInterest() {
		return approvedInterest;
	}
	/**
	 * @param approvedInterest the approvedInterest to set
	 */
	public void setApprovedInterest(double approvedInterest) {
		this.approvedInterest = approvedInterest;
	}
	
	/**
	 * @return the borrowerMobile
	 */
	public String getBorrowerMobile() {
		return borrowerMobile;
	}
	/**
	 * @param borrowerMobile the borrowerMobile to set
	 */
	public void setBorrowerMobile(String borrowerMobile) {
		this.borrowerMobile = borrowerMobile;
	}
	/**
	 * @return the lenderMobile
	 */
	public String getLenderMobile() {
		return lenderMobile;
	}
	/**
	 * @param lenderMobile the lenderMobile to set
	 */
	public void setLenderMobile(String lenderMobile) {
		this.lenderMobile = lenderMobile;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the requestStatus
	 */
	public String getRequestStatus() {
		return requestStatus;
	}
	/**
	 * @param requestStatus the requestStatus to set
	 */
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PPLoan [id=" + id + ", requestId=" + requestId + ", requesterType=" + requesterType + ", requestAmount="
				+ requestAmount + ", requestTenure=" + requestTenure + ", requestInterest=" + requestInterest
				+ ", approvedAmount=" + approvedAmount + ", approvedTenure=" + approvedTenure + ", approvedInterest="
				+ approvedInterest + ", borrowerMobile=" + borrowerMobile + ", lenderMobile=" + lenderMobile
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", comment=" + comment
				+ ", requestStatus=" + requestStatus + "]";
	}
	
	
	
}
