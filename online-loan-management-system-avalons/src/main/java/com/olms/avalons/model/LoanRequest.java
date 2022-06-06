/**
 * 
 */
package com.olms.avalons.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.apache.commons.lang3.StringUtils;

import com.olms.avalons.constants.Constants;
import com.olms.avalons.utils.DateUtils;

/**
 * Loan Request Model.
 *
 * @author Samba Chennamsetty
 * @since Jun 5, 2022
 */
public class LoanRequest {

	private Long requestId;
	private BigDecimal amount;
	private Long emiMonths;
	private String purpose;
	private String status;
	private Timestamp loanRequestedDate;

	private Long customerId;
	private Long offerId;
	private Long branchId;
	
	private String customerName;

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Long getEmiMonths() {
		return emiMonths;
	}

	public void setEmiMonths(Long emiMonths) {
		this.emiMonths = emiMonths;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getLoanRequestedDate() {
		return loanRequestedDate;
	}

	public void setLoanRequestedDate(Timestamp loanRequestedDate) {
		this.loanRequestedDate = loanRequestedDate;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
	public String getLoanStatus() {

		if (StringUtils.equals(this.status, Constants.APPROVED)) {
			return "Approved";
		}

		if (StringUtils.equals(this.status, Constants.DECLINED)) {
			return "Declined";
		}

		if (StringUtils.equals(this.status, Constants.PROCESSING)) {
			return "Processing";
		}

		return "";
	}

	public String getDisplaySubmittedDate() {

		if (loanRequestedDate == null) {
			return "";
		}

		return DateUtils.format(loanRequestedDate, DateUtils.getDisplayDateTime());
	}
	
}
