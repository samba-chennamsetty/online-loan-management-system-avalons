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
 * Payment information entity that stores payment information.
 *
 * @author Samba Chennamsetty
 * @since Apr 18, 2022
 */
@Entity
@Table(name = "payment_information")
public class PaymentInformationEntity {

	private Long paymentId;
	private Double paymentAmount;
	private Date paymentDate;

	private LoanInformationEntity infoEntity;
	private CustomerEntity customer;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	@Column(name = "payment_amount")
	public Double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	@Column(name = "payment_date")
	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "info_id")
	public LoanInformationEntity getInfoEntity() {
		return infoEntity;
	}

	public void setInfoEntity(LoanInformationEntity infoEntity) {
		this.infoEntity = infoEntity;
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