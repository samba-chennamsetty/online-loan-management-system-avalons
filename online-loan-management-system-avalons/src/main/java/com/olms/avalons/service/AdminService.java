package com.olms.avalons.service;

import com.olms.avalons.model.Admin;

/**
 * Admin service interface.
 *
 * @author Samba Chennamsetty
 * @since Apr 24, 2022
 */
public interface AdminService {

	public Admin getByUserIdAndPassword(final String emailId, final String password);
}
