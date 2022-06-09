/**
 * 
 */
package com.olms.avalons.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olms.avalons.model.PaymentInformation;
import com.olms.avalons.repository.PaymentInfoRepository;
import com.olms.avalons.service.PaymentInformationService;

/**
 * Payment information service that process services related to payment info.
 *
 * @author Samba Chennamsetty
 * @since Jun 8, 2022
 */
@Service
@Transactional
public class PaymentInformationServiceImpl implements PaymentInformationService {

	@Autowired
	private PaymentInfoRepository infoRepo;

	@Override
	public void savePaymentInfo(final PaymentInformation info) {

		infoRepo.savePaymentInfo(info);
	}
}
