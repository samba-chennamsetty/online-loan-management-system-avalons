package com.olms.avalons.service;

import java.util.List;

import com.olms.avalons.model.LoanRequest;

/**
 * Loan Request Service.
 *
 * @author Samba Chennamsetty
 * @since Jun 5, 2022
 */
public interface LoanRequestsService {

	void saveLoanRequest(final LoanRequest loanRequest);

	List<LoanRequest> getAllLoanRequests(final Long employeeId, final String status);
	
	void processLoanRequest(final Long loanRequestId, final String status);
}
