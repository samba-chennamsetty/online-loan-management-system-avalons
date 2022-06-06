package com.olms.avalons.service;

import com.olms.avalons.model.Employee;

/**
 * Employee service interface.
 *
 * @author Samba Chennamsetty
 * @since Apr 24, 2022
 */
public interface EmployeeService {

	public Employee getByUserIdAndPasswordAndBranchId(final String emailId, final String password, final Long branchId);

	public Employee getById(final Long empId);
}
