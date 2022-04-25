package com.olms.avalons.controller;

import static com.olms.avalons.utils.SessionUtils.isAdminLoggedIn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Admin Controller.
 *
 * @author Samba Chennamsetty
 * @since Apr 19, 2022
 */
@Controller
@RequestMapping("admin")
public class AdminController {

	@GetMapping("display")
	public ModelAndView home(final HttpServletRequest request, final HttpServletResponse response) {

		if (isAdminLoggedIn(request)) {
			return new ModelAndView("admin-dashboard");
		}

		return new ModelAndView("redirect:/admin-login/display");
	}
}
