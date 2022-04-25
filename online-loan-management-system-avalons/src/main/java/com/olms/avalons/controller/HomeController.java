package com.olms.avalons.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Home controller.
 *
 * @author Samba Chennamsetty
 * @since Apr 24, 2022
 */
@Controller
public class HomeController {

	@GetMapping("/")
	public ModelAndView home(Model model) {

		System.out.println("came to home");

		return new ModelAndView("index");
	}
}
