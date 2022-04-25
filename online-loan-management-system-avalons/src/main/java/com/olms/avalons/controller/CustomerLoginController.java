package com.olms.avalons.controller;

import static com.olms.avalons.utils.SessionUtils.CUSTOMER_LOGIN;
import static com.olms.avalons.utils.SessionUtils.isCustomerLoggedIn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.olms.avalons.command.CustomerCommand;
import com.olms.avalons.model.Customer;
import com.olms.avalons.service.CustomerService;

/**
 * Customer login controller.
 *
 * @author Samba Chennamsetty
 * @since Apr 24, 2022
 */
@Controller
@RequestMapping("customer")
public class CustomerLoginController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("display")
	public ModelAndView display(final HttpServletRequest request,
			@ModelAttribute("customerLogin") CustomerCommand customerLogin, final BindingResult result) {

		if (isCustomerLoggedIn(request)) {
			return new ModelAndView("redirect:/customer-dashboard/display");
		}

		return new ModelAndView("customer");
	}

	@PostMapping("login")
	public ModelAndView login(final HttpServletRequest request,
			@ModelAttribute("customerLogin") CustomerCommand customerLogin, final BindingResult result) {

		if (isCustomerLoggedIn(request)) {
			return new ModelAndView("redirect:/customer-dashboard/display");
		}

		final ModelAndView modelAndView = new ModelAndView("customer");
		final Customer customer = customerService.getByUserNameAndPassword(customerLogin.getEmailId(),
				customerLogin.getPassword());

		if (customer == null) {
			modelAndView.addObject("invalidCustomerLogin", "Invalid credentials..");
			return modelAndView;
		}

		final HttpSession session = request.getSession();
		session.setAttribute(CUSTOMER_LOGIN, customer);

		return new ModelAndView("redirect:/customer-dashboard/display");
	}

	@PostMapping("register")
	public ModelAndView register(final HttpServletRequest request,
			@ModelAttribute("customerLogin") CustomerCommand customerLogin, final BindingResult result) {

		System.out.println("register Came");

		final Customer customer = new Customer();
		org.springframework.beans.BeanUtils.copyProperties(customerLogin, customer);

		customerService.saveCustomer(customer);

		final ModelAndView modelAndView = new ModelAndView("customer");
		modelAndView.addObject("successMessage", "Registration Completed Successfully..");

		return new ModelAndView("customer");
	}

	@GetMapping("logout")
	public ModelAndView logout(final HttpServletRequest request) {

		final HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}

		final ModelAndView modelAndView = new ModelAndView("redirect:/customer/display");

		return modelAndView;
	}
}
