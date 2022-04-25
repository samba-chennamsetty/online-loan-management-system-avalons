package com.olms.avalons.service.impl;

import static org.springframework.beans.BeanUtils.copyProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olms.avalons.entity.CustomerEntity;
import com.olms.avalons.model.Customer;
import com.olms.avalons.repository.CustomerRepository;
import com.olms.avalons.service.CustomerService;

/**
 * Customer service implementation.
 *
 * @author Samba Chennamsetty
 * @since Apr 18, 2022
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer getByUserNameAndPassword(final String userName, final String password) {

		final CustomerEntity customerEntity = customerRepository.findByCustomerNameAndPassword(userName, password);

		if (customerEntity == null) {
			return null;
		}

		final Customer customer = new Customer();
		copyProperties(customerEntity, customer);
		return customer;
	}

	@Override
	public Long saveCustomer(final Customer customer) {

		customerRepository.saveCustomer(customer);

		final Long customerId = customerRepository.findLastInsertedId();

		return customerId;
	}
}
