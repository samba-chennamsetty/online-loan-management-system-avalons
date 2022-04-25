package com.olms.avalons.service;

import java.util.List;

import com.olms.avalons.model.LoanOffers;

/**
 * Loan offer service.
 *
 * @author Samba Chennamsetty
 * @since Apr 22, 2022
 */
public interface LoanOffersService {

	void saveLoanOffer(final LoanOffers offer);

	List<LoanOffers> getLoanOffers();

	void updateLoanOffers(final LoanOffers offer);

	LoanOffers findById(final Long loanOfferId);

	void deleteById(final Long id);
}
