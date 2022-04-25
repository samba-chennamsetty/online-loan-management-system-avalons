package com.olms.avalons.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olms.avalons.entity.AdminEntity;
import com.olms.avalons.model.Admin;
import com.olms.avalons.repository.AdminRepository;
import com.olms.avalons.service.AdminService;

/**
 * Admin service implementation.
 *
 * @author Samba Chennamsetty
 * @since Apr 18, 2022
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin getByUserIdAndPassword(final String emailId, final String password) {

		final AdminEntity adminEntity = adminRepository.findByUserNameAndPassword(emailId, password);

		if (adminEntity == null) {
			return null;
		}

		final Admin admin = new Admin();
		BeanUtils.copyProperties(adminEntity, admin);

		return admin;
	}
}
