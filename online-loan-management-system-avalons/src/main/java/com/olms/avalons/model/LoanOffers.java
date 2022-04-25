package com.olms.avalons.model;

import java.math.BigDecimal;

/**
 * Loan offers model.
 *
 * @author Samba Chennamsetty
 * @since Apr 24, 2022
 */
public class LoanOffers {

	private Long loanId;
	private String loanName;
	private Double amount;
	private String loanRange;
	private BigDecimal interest;

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public String getLoanName() {
		return loanName;
	}

	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getLoanRange() {
		return loanRange;
	}

	public void setLoanRange(String loanRange) {
		this.loanRange = loanRange;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}
}
