/**
 * 
 */
package com.olms.avalons.service;

import java.util.List;

import com.olms.avalons.model.Emi;
import com.olms.avalons.model.PaymentInformation;

/**
 * Emi Service class to process emi related services.
 *
 * @author Samba Chennamsetty
 * @since Jun 6, 2022
 */
public interface EmiService {

	void saveEmi(final Emi emi);

	List<Emi> getEmis(final Long loanInfoId);

	Emi getEmiById(final Long emiId);

	void updatePayment(final PaymentInformation info);
}
