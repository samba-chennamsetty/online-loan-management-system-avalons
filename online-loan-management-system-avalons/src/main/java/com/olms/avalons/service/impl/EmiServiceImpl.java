/**
 * 
 */
package com.olms.avalons.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olms.avalons.model.Emi;
import com.olms.avalons.repository.EmiRepository;
import com.olms.avalons.service.EmiService;

/**
 * Service implementation of {@link EmiService}
 *
 * @author Samba Chennamsetty
 * @since Jun 6, 2022
 */
@Service
@Transactional
public class EmiServiceImpl implements EmiService {

	@Autowired
	private EmiRepository emiRepository;

	@Override
	public void saveEmi(final Emi emi) {

		emiRepository.saveEmi(emi);
	}
}
