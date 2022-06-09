package com.olms.avalons.controller;

import static com.olms.avalons.constants.Constants.APPROVED;
import static com.olms.avalons.constants.Constants.DECLINED;
import static com.olms.avalons.constants.Constants.PROCESSING;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.olms.avalons.constants.Constants;
import com.olms.avalons.model.Branch;
import com.olms.avalons.model.Customer;
import com.olms.avalons.model.Employee;
import com.olms.avalons.model.LoanInformation;
import com.olms.avalons.model.LoanOffer;
import com.olms.avalons.model.LoanRequest;
import com.olms.avalons.service.BranchService;
import com.olms.avalons.service.LoanOffersService;
import com.olms.avalons.service.LoanRequestsService;
import com.olms.avalons.service.UserActivityService;
import com.olms.avalons.utils.SessionUtils;

/**
 * Loan Request controller that handles requests related to loan request.
 *
 * @author Samba Chennamsetty
 * @since Apr 26, 2022
 */
@Controller
@RequestMapping("loan-request")
public class LoanRequestController {

	@Autowired
	private LoanOffersService loanOffersService;

	@Autowired
	private LoanRequestsService loanRequestService;

	@Autowired
	private BranchService branchService;

	@Autowired
	private UserActivityService activityService;

	@GetMapping("save")
	public ModelAndView applyLoan(final HttpServletRequest request,
			@ModelAttribute("loanRequest") LoanRequest loanRequest) {

		final ModelAndView modelAndView = new ModelAndView("apply-loan");

		final List<LoanOffer> loanOffers = loanOffersService.getLoanOffers();
		modelAndView.addObject("loanOffers", prepareLoanOffers(loanOffers));
		final List<Branch> branches = branchService.getAllBranches();
		modelAndView.addObject("branches", prepareBranches(branches));

		return modelAndView;
	}

	Map<Long, String> prepareLoanOffers(final List<LoanOffer> loanOffers) {

		final Map<Long, String> loans = new LinkedHashMap<Long, String>();
		for (LoanOffer loanOffer : loanOffers) {
			final String loanInfo = loanOffer.getLoanName() + " - " + "with " + loanOffer.getInterest() + "% I.R.(Upto "
					+ loanOffer.getLoanRange() + " $)";

			loans.put(loanOffer.getOfferId(), loanInfo);
		}

		return loans;
	}

	Map<Long, String> prepareBranches(final List<Branch> branches) {

		final Map<Long, String> branchess = new LinkedHashMap<Long, String>();
		for (Branch branch : branches) {
			final String branchInfo = branch.getBranchCode() + " - " + branch.getName();

			branchess.put(branch.getBranchId(), branchInfo);
		}

		return branchess;
	}

	@PostMapping("submit")
	public ModelAndView submit(final HttpServletRequest request,
			@ModelAttribute("loanRequest") LoanRequest loanRequest) {

		final ModelAndView modelAndView = new ModelAndView("apply-loan", "loanRequest", new LoanRequest());
		final List<LoanOffer> loanOffers = loanOffersService.getLoanOffers();
		modelAndView.addObject("loanOffers", prepareLoanOffers(loanOffers));
		final List<Branch> branches = branchService.getAllBranches();
		modelAndView.addObject("branches", prepareBranches(branches));

		final Customer customer = SessionUtils.getCustomerInfo(request);
		loanRequest.setCustomerId(customer.getCustomerId());

		loanRequestService.saveLoanRequest(loanRequest);

		activityService.saveUserActivity(Constants.APPLIED, customer.getCustomerId());

		modelAndView.addObject("saveMessage", "Loan Requested Successfully..");

		return modelAndView;
	}

	@GetMapping("requested-list")
	public ModelAndView showRequestedLoans(final HttpServletRequest request) {

		final Employee employee = SessionUtils.getEmployeeInfo(request);

		final ModelAndView modelAndView = new ModelAndView("loan-request-list");
		final List<LoanRequest> requests = loanRequestService.getAllLoanRequests(employee.getEmpId(), PROCESSING);

		modelAndView.addObject("requests", requests);

		return modelAndView;
	}

	@GetMapping("by-customer-id")
	public ModelAndView getByCustomerId(final HttpServletRequest request) {

		final Customer customer = SessionUtils.getCustomerInfo(request);

		final ModelAndView modelAndView = new ModelAndView("loans-info");
		final List<LoanInformation> infos = loanRequestService.getAllLoanRequestsByCustomerId(customer.getCustomerId());

		modelAndView.addObject("infos", infos);

		return modelAndView;
	}

	@GetMapping("approved-list")
	public ModelAndView showApprovedLoans(final HttpServletRequest request) {

		final Employee employee = SessionUtils.getEmployeeInfo(request);

		final ModelAndView modelAndView = new ModelAndView("loan-request-approved");
		final List<LoanRequest> requests = loanRequestService.getAllLoanRequests(employee.getEmpId(), APPROVED);

		modelAndView.addObject("requests", requests);

		return modelAndView;
	}

	@GetMapping("declined-list")
	public ModelAndView showDeclinedLoans(final HttpServletRequest request) {

		final Employee employee = SessionUtils.getEmployeeInfo(request);

		final ModelAndView modelAndView = new ModelAndView("loan-request-declined");
		final List<LoanRequest> requests = loanRequestService.getAllLoanRequests(employee.getEmpId(), DECLINED);

		modelAndView.addObject("requests", requests);

		return modelAndView;
	}

	@PostMapping("approve")
	@ResponseBody
	public ModelMap approveLoan(final HttpServletRequest request, @RequestBody Long requesId) {

		loanRequestService.processLoanRequest(requesId, Constants.APPROVED);
		final ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("message", "Loan Approved...");
		return modelMap;
	}

	@PostMapping("decline")
	@ResponseBody
	public ModelMap declineLoan(final HttpServletRequest request, @RequestBody Long requesId) {

		loanRequestService.processLoanRequest(requesId, Constants.DECLINED);
		final ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("message", "Loan Declined...");
		return modelMap;
	}
}
