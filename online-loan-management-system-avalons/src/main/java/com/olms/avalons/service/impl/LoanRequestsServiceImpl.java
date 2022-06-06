package com.olms.avalons.service.impl;

import static org.apache.commons.collections.CollectionUtils.isEmpty;
import static org.springframework.beans.BeanUtils.copyProperties;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olms.avalons.constants.Constants;
import com.olms.avalons.entity.LoanRequestsEntity;
import com.olms.avalons.model.Employee;
import com.olms.avalons.model.LoanRequest;
import com.olms.avalons.repository.LoanRequestsRepository;
import com.olms.avalons.service.LoanRequestsService;
import com.olms.avalons.utils.DateUtils;

@Service
public class LoanRequestsServiceImpl implements LoanRequestsService {

	@Autowired
	private LoanRequestsRepository requestRepository;

	@Autowired
	private EmployeeServiceImpl employeeService;

	@Override
	public void saveLoanRequest(final LoanRequest loanRequest) {

		loanRequest.setStatus(Constants.PROCESSING);
		loanRequest.setLoanRequestedDate(DateUtils.currentTimestamp());

		requestRepository.saveloanRequest(loanRequest);

	}

	@Override
	public List<LoanRequest> getAllLoanRequests(final Long employeeId, final String status) {
		
		final Employee employee = employeeService.getById(employeeId);

		final List<LoanRequestsEntity> entities = requestRepository.findAllLoanRequests(employee.getBranchId(), status);

		if (isEmpty(entities)) {
			return new ArrayList<LoanRequest>();
		}

		return toServiceModel(entities);
	}

	final List<LoanRequest> toServiceModel(final List<LoanRequestsEntity> entities) {

		final List<LoanRequest> requests = new ArrayList<LoanRequest>();
		for (LoanRequestsEntity entity : entities) {
			final LoanRequest transaction = new LoanRequest();

			System.out.println(entity.getCustomerEntity().getAddress());
			copyProperties(entity, transaction);
			transaction.setCustomerName(
					entity.getCustomerEntity().getFirstName() + " " + entity.getCustomerEntity().getLastName());

			requests.add(transaction);
		}

		return requests;
	}
	
	@Override
	public void processLoanRequest(final Long loanRequestId, final String status) {
	
		requestRepository.processLoanRequest(loanRequestId, status);
	}
}
