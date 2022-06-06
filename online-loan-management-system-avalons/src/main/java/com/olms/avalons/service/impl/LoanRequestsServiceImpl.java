package com.olms.avalons.service.impl;

import static com.olms.avalons.utils.DateUtils.addMonths;
import static com.olms.avalons.utils.DateUtils.currentTimestamp;
import static com.olms.avalons.utils.DateUtils.toTimestamp;
import static org.apache.commons.collections.CollectionUtils.isEmpty;
import static org.springframework.beans.BeanUtils.copyProperties;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olms.avalons.constants.Constants;
import com.olms.avalons.entity.LoanRequestsEntity;
import com.olms.avalons.model.Emi;
import com.olms.avalons.model.Employee;
import com.olms.avalons.model.LoanInformation;
import com.olms.avalons.model.LoanRequest;
import com.olms.avalons.repository.LoanRequestsRepository;
import com.olms.avalons.service.EmiService;
import com.olms.avalons.service.LoanInformationService;
import com.olms.avalons.service.LoanRequestsService;
import com.olms.avalons.utils.DateUtils;

@Service
public class LoanRequestsServiceImpl implements LoanRequestsService {

	@Autowired
	private LoanRequestsRepository requestRepository;

	@Autowired
	private EmployeeServiceImpl employeeService;

	@Autowired
	private LoanInformationService infoService;

	@Autowired
	private EmiService emiService;

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

		final LoanRequestsEntity entity = requestRepository.findLoanRequestById(loanRequestId);

		final Long loanInfoId = saveLoanInfo(entity);

		saveEmiDetails(entity, loanInfoId);
	}

	/**
	 * Saves the emi details for the given loan information.
	 * 
	 * @param entity     entity.
	 * @param loanInfoId loan info id.
	 */
	private void saveEmiDetails(final LoanRequestsEntity entity, final Long loanInfoId) {
		
		final Double monthInterest = (entity.getOffersEntity().getInterest().doubleValue() * entity.getAmount().doubleValue()) / 100;
		final Double totalInterest = monthInterest* entity.getEmiMonths(); 
		
		final Double totalAmount = entity.getAmount().doubleValue() + totalInterest;
		
		final Double monthlyAmount = totalAmount  / entity.getEmiMonths();
		Double balance = totalAmount;

		Calendar now = Calendar.getInstance();
		for (Integer i = 1; i <= entity.getEmiMonths(); i++) {

			balance = balance - monthlyAmount;
			now.add(Calendar.MONTH, 1);

			final Emi emi = new Emi();
			emi.setCurrentBalance(new BigDecimal(balance));
			emi.setCustomerId(entity.getCustomerEntity().getCustomerId());
			emi.setLoanInfoId(loanInfoId);
			emi.setPayment(new BigDecimal(monthlyAmount));
			emi.setPaymentDate(new Date(now.getTimeInMillis()));
			emi.setPeriod(i.longValue());
			emi.setStatus("P");

			emiService.saveEmi(emi);
		}
	}

	/**
	 * save approved loan info.
	 * 
	 * @param entity request entity.
	 * @return last inserted id.
	 */
	private Long saveLoanInfo(final LoanRequestsEntity entity) {

		final LoanInformation info = new LoanInformation();
		info.setCustomerId(entity.getCustomerEntity().getCustomerId());
		info.setLoanRequestId(entity.getRequestId());
		info.setLoanDate(currentTimestamp());
		info.setLoanDueDate(toTimestamp(addMonths(entity.getEmiMonths().intValue())));

		infoService.saveLoanInfo(info);

		return infoService.getLastInsertedId();
	}
}
