package com.olms.avalons.service;

import com.olms.avalons.model.Customer;

/**
 * Customer service interface.
 *
 * @author Samba Chennamsetty
 * @since Apr 24, 2022
 */
public interface CustomerService {

	Customer getByUserNameAndPassword(final String userName, final String password);

	Long saveCustomer(final Customer customre);
}
