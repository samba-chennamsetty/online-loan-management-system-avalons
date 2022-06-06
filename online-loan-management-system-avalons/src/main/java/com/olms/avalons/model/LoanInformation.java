/**
 * 
 */
package com.olms.avalons.model;

import java.util.Date;

/**
 * Loan Information model that contains approved loan info.
 *
 * @author Samba Chennamsetty
 * @since Jun 5, 2022
 */
public class LoanInformation {

	private Long infoId;
	private Date loanDate;
	private Date loanDueDate;
	private Long customerId;
	private Long loanRequestId;

	public Long getInfoId() {
		return infoId;
	}

	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public Date getLoanDueDate() {
		return loanDueDate;
	}

	public void setLoanDueDate(Date loanDueDate) {
		this.loanDueDate = loanDueDate;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getLoanRequestId() {
		return loanRequestId;
	}

	public void setLoanRequestId(Long loanRequestId) {
		this.loanRequestId = loanRequestId;
	}
}
