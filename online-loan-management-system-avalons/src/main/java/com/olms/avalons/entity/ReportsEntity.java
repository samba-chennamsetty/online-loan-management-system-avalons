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
 * Reports entity that stores loan & customer information.
 *
 * @author Samba Chennamsetty
 * @since Apr 18, 2022
 */
@Entity
@Table(name = "reports")
public class ReportsEntity {

	private Long reportId;
	private Date reportDate;

	private LoanOffersEntity loanOffersEntity;
	private LoanInformationEntity loanInfoEntity;
	private PaymentInformationEntity paymentInfoEntity;
	private CustomerEntity customer;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_id")
	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	@Column(name = "report_date")
	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "info_id")
	public LoanInformationEntity getLoanInfoEntity() {
		return loanInfoEntity;
	}

	public void setLoanInfoEntity(LoanInformationEntity loanInfoEntity) {
		this.loanInfoEntity = loanInfoEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loan_id")
	public LoanOffersEntity getLoanOffersEntity() {
		return loanOffersEntity;
	}

	public void setLoanOffersEntity(LoanOffersEntity loanOffersEntity) {
		this.loanOffersEntity = loanOffersEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_id")
	public PaymentInformationEntity getPaymentInfoEntity() {
		return paymentInfoEntity;
	}

	public void setPaymentInfoEntity(PaymentInformationEntity paymentInfoEntity) {
		this.paymentInfoEntity = paymentInfoEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
}