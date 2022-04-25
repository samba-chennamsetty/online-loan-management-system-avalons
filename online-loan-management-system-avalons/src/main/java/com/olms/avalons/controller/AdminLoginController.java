package com.olms.avalons.controller;

import static com.olms.avalons.utils.SessionUtils.ADMIN_LOGIN;
import static com.olms.avalons.utils.SessionUtils.isAdminLoggedIn;

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

import com.olms.avalons.model.Admin;
import com.olms.avalons.service.AdminService;

/**
 * Admin Login Controller.
 *
 * @author Samba Chennamsetty
 * @since Apr 24, 2022
 */
@Controller
@RequestMapping("admin-login")
public class AdminLoginController {

	@Autowired
	private AdminService adminService;

	@GetMapping("display")
	public ModelAndView home(final HttpServletRequest request, @ModelAttribute("adminLogin") Admin adminLogin,
			final BindingResult result) {

		if (isAdminLoggedIn(request)) {
			return new ModelAndView("redirect:/admin/display");
		}

		return new ModelAndView("admin-login");
	}

	@PostMapping("submit")
	public ModelAndView submit(final HttpServletRequest request, @ModelAttribute("adminLogin") Admin adminLogin,
			final BindingResult result) {

		final ModelAndView modelAndView = new ModelAndView("admin-login");
		final Admin admin = adminService.getByUserIdAndPassword(adminLogin.getEmailId(), adminLogin.getPassword());

		if (admin == null) {
			modelAndView.addObject("invalidAdminLogin", "Invalid credentials..");
			return modelAndView;
		}

		final HttpSession session = request.getSession();
		session.setAttribute(ADMIN_LOGIN, admin);

		return new ModelAndView("redirect:/admin/display");
	}

	@GetMapping("logout")
	public ModelAndView logout(final HttpServletRequest request) {

		final HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}

		final ModelAndView modelAndView = new ModelAndView("redirect:/admin-login/display");

		return modelAndView;
	}
}
