package com.olms.avalons.service.impl;

import static org.apache.commons.collections.CollectionUtils.isEmpty;
import static org.springframework.beans.BeanUtils.copyProperties;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olms.avalons.entity.LoanOffersEntity;
import com.olms.avalons.model.LoanOffers;
import com.olms.avalons.repository.LoanOffersRepository;
import com.olms.avalons.service.LoanOffersService;

/**
 * Loan offers service implementation.
 *
 * @author Samba Chennamsetty
 * @since Apr 24, 2022
 */
@Service
public class LoanOffersServiceImpl implements LoanOffersService {

	@Autowired
	private LoanOffersRepository repository;

	@Override
	public void saveLoanOffer(final LoanOffers offer) {

		repository.saveloanOffer(offer);

		// TO-DO
		// % giving expection when we give 11.2 % like this, if we give 2.2 it is
		// working fine

		final Long loanOfferId = repository.findLastInsertedId();
	}

	@Override
	public List<LoanOffers> getLoanOffers() {

		final List<LoanOffersEntity> entities = repository.findAllLoanOffers();

		if (isEmpty(entities)) {
			return new ArrayList<LoanOffers>();
		}

		return toServiceModel(entities);
	}

	final List<LoanOffers> toServiceModel(final List<LoanOffersEntity> entities) {

		final List<LoanOffers> offers = new ArrayList<LoanOffers>();
		for (LoanOffersEntity entity : entities) {
			final LoanOffers offer = new LoanOffers();
			copyProperties(entity, offer);
			offers.add(offer);
		}

		return offers;
	}

	@Override
	public void updateLoanOffers(final LoanOffers offer) {

		repository.updateLoanOffer(offer);

	}

	@Override
	public LoanOffers findById(final Long loanOfferId) {

		final LoanOffersEntity entity = repository.findByLoanId(loanOfferId);
		final LoanOffers offer = new LoanOffers();
		copyProperties(entity, offer);

		return offer;
	}

	@Override
	public void deleteById(final Long id) {

		repository.deleteById(id);

	}
}
