package com.olms.avalons.service;

import java.util.List;

import com.olms.avalons.model.LoanOffer;

/**
 * Loan offer service.
 *
 * @author Samba Chennamsetty
 * @since Apr 22, 2022
 */
public interface LoanOffersService {

	void saveLoanOffer(final LoanOffer offer);

	List<LoanOffer> getLoanOffers();

	void updateLoanOffers(final LoanOffer offer);

	LoanOffer findById(final Long loanOfferId);

	void deleteById(final Long id);
}
