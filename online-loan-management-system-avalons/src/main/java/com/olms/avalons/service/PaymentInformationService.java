/**
 * 
 */
package com.olms.avalons.service;

import com.olms.avalons.model.PaymentInformation;

/**
 * Payment information service that handles payment related service.
 *
 * @author Samba Chennamsetty
 * @since Jun 7, 2022
 */
public interface PaymentInformationService {

	void savePaymentInfo(final PaymentInformation info);
}
