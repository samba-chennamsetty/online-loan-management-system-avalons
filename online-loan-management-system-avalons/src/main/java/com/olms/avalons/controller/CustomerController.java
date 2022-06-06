package com.olms.avalons.controller;

import static com.olms.avalons.utils.SessionUtils.isCustomerLoggedIn;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.olms.avalons.command.CustomerCommand;

/**
 * Customer Controller.
 *
 * @author Samba Chennamsetty
 * @since Apr 24, 2022
 */
@Controller
@RequestMapping("customer-dashboard")
public class CustomerController {

	@GetMapping("display")
	public ModelAndView afterLogin(final HttpServletRequest request,
			@ModelAttribute("customerLogin") CustomerCommand customerLogin, final BindingResult result) {

		if (isCustomerLoggedIn(request)) {
			return new ModelAndView("customer-dashboard");
		}

		return new ModelAndView("redirect:/customer/display");
	}

}
