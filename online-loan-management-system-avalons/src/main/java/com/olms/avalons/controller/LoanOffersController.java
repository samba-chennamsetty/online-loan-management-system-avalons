package com.olms.avalons.controller;

import java.util.List;

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

import com.olms.avalons.model.LoanOffers;
import com.olms.avalons.service.LoanOffersService;

/**
 * Loan offer controller.
 *
 * @author Samba Chennamsetty
 * @since Apr 24, 2022
 */
@Controller
@RequestMapping("loan-offers")
public class LoanOffersController {

	@Autowired
	private LoanOffersService offerService;

	@GetMapping("display")
	public ModelAndView showLoanOffers(final HttpServletRequest request,
			@ModelAttribute("loanOffers") LoanOffers loanOffers) {

		final ModelAndView modelAndView = new ModelAndView("loan-offers-list");
		final List<LoanOffers> offers = offerService.getLoanOffers();

		modelAndView.addObject("offers", offers);

		return modelAndView;
	}

	@GetMapping("save")
	public ModelAndView save(final HttpServletRequest request, @ModelAttribute("loanOffers") LoanOffers loanOffers) {

		return new ModelAndView("loan-offers-reg");
	}

	@PostMapping("get-loan-offer")
	@ResponseBody
	public ModelMap getLoan(final HttpServletRequest request, @RequestBody Long loanOfferId) {

		System.out.println(loanOfferId);

		final LoanOffers loanOffer = offerService.findById(loanOfferId);

		final ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("loanOffer", loanOffer);
		return modelMap;
	}

	@PostMapping("delete-loan-offer")
	@ResponseBody
	public ModelMap DeleteLoan(final HttpServletRequest request, @RequestBody Long loanOfferId) {

		System.out.println(loanOfferId);

		offerService.deleteById(loanOfferId);

		final ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("deleteMessage", "Loan Offer Deleted Successfully..");
		return modelMap;
	}

	@PostMapping("update-loan-offer")
	@ResponseBody
	public ModelMap updateLoanOffer(final HttpServletRequest request, @RequestBody LoanOffers loanOffers) {

		offerService.updateLoanOffers(loanOffers);

		final ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("updateMessage", "Loan Offer Updated Successfully..");
		return modelMap;
	}

	@PostMapping("submit")
	public ModelAndView submit(final HttpServletRequest request, @ModelAttribute("loanOffers") LoanOffers loanOffers) {

		final ModelAndView modelAndView = new ModelAndView("loan-offers-reg");

		offerService.saveLoanOffer(loanOffers);

		modelAndView.addObject("saveMessage", "Loan Offer Saved Successfully..");

		return modelAndView;
	}

}
