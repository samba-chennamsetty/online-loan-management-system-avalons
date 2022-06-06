package com.olms.avalons.service;

import java.util.List;

import com.olms.avalons.model.LoanType;

/**
 * Loan type service.
 *
 * @author Samba Chennamsetty
 * @since May 4, 2022
 */
public interface LoanTypeService {

	List<LoanType> getLoanTypes();
}
