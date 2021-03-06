/**
 * 
 */
package com.olms.avalons.service;

import java.util.List;

import com.olms.avalons.model.LoanInformation;

/**
 * Loan info service that handles services related to loan info.
 *
 * @author Samba Chennamsetty
 * @since Jun 5, 2022
 */
public interface LoanInformationService {

	void saveLoanInfo(final LoanInformation loanInfo);

	LoanInformation getLoanInformation(final Long infoId);
	
	LoanInformation getLoanInformationByRequestId(final Long requestId);

	List<LoanInformation> getLoanInformationByCustomerId(final Long customerId);

	Long getLastInsertedId();
}
