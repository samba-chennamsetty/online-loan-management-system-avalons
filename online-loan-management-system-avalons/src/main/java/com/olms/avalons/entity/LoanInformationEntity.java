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
 * Loan information entity that stores approved loan information.
 *
 * @author Samba Chennamsetty
 * @since Apr 18, 2022
 */
@Entity
@Table(name = "loan_information")
public class LoanInformationEntity {

	private Long infoId;
	// Loan approved date.
	private Date loanDate;
	// loan due date.
	private Date loanDue;
	private Integer paymentRange;

	private CustomerEntity customer;
	private LoanOffersEntity offersEntity;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "info_id")
	public Long getInfoId() {
		return infoId;
	}

	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}

	@Column(name = "loan_date")
	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	@Column(name = "loan_due")
	public Date getLoanDue() {
		return loanDue;
	}

	public void setLoanDue(Date loanDue) {
		this.loanDue = loanDue;
	}

	@Column(name = "payment_range")
	public Integer getPaymentRange() {
		return paymentRange;
	}

	public void setPaymentRange(Integer paymentRange) {
		this.paymentRange = paymentRange;
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