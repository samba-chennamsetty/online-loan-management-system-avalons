/**
 * 
 */
package com.olms.avalons.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olms.avalons.model.LoanInformation;
import com.olms.avalons.repository.LoanInformationRepository;
import com.olms.avalons.service.LoanInformationService;

/**
 * Implementation of {@link LoanInformationService}
 *
 * @author Samba Chennamsetty
 * @since Jun 5, 2022
 */
@Service
public class LoanInformationServiceImpl implements LoanInformationService {

	@Autowired
	private LoanInformationRepository loanInfoRepo;

	@Override
	public void saveLoanInfo(final LoanInformation loanInfo) {

		loanInfoRepo.saveloanInfo(loanInfo);
	}

	@Override
	public LoanInformation getLoanInformation(final Long infoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoanInformation getLoanInformationByCustomerId(final Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Long getLastInsertedId() {

		return  loanInfoRepo.findLastInsertedId();
	}
}
