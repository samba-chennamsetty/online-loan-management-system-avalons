package com.olms.avalons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Loan transaction entity that stores loan request information.
 *
 * @author Samba Chennamsetty
 * @since Apr 18, 2022
 */
@Entity
@Table(name = "loan_transaction")
public class LoanTransactionsEntity {

	private Long transactionId;
	private Date loanRequestedDate;
	private String purpose;
	private String collateral;
	private String status;

	private CustomerEntity customer;
	private LoanOffersEntity offersEntity;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	@Column(name = "requested_date")
	public Date getLoanRequestedDate() {
		return loanRequestedDate;
	}

	public void setLoanRequestedDate(Date loanRequestedDate) {
		this.loanRequestedDate = loanRequestedDate;
	}

	@Column(name = "purpose")
	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Column(name = "collateral")
	public String getCollateral() {
		return collateral;
	}

	public void setCollateral(String collateral) {
		this.collateral = collateral;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loan_id")
	public LoanOffersEntity getOffersEntity() {
		return offersEntity;
	}

	public void setOffersEntity(LoanOffersEntity offersEntity) {
		this.offersEntity = offersEntity;
	}
}