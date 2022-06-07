/**
 * 
 */
package com.olms.avalons.service.impl;

import static org.springframework.beans.BeanUtils.copyProperties;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olms.avalons.entity.EmiEntity;
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

	@Override
	public List<Emi> getEmis(final Long loanInfoId) {

		return getEmis(emiRepository.findEmisByLoanInfoId(loanInfoId));
	}

	/**
	 * Converts entities to models.
	 * 
	 * @param entities entities.
	 * @return returns models.
	 */
	List<Emi> getEmis(final List<EmiEntity> entities) {

		final List<Emi> emis = new ArrayList<Emi>();

		for (EmiEntity entity : entities) {

			Emi emi = new Emi();
			copyProperties(entity, emi);
			emis.add(emi);
		}

		for (Emi emi : emis) {

			if (emi.getStatus().equals("P")) {
				emi.setPaymentOption(true);
				break;
			}
		}

		return emis;
	}
}
