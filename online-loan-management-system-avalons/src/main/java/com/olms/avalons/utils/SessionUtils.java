package com.olms.avalons.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

/**
 * Session utils to store user & admin info in session.
 *
 * @author Samba Chennamsetty
 * @since Apr 18, 2022
 */
public class SessionUtils {

	public static final String ADMIN_LOGIN = "ADMIN_LOGIN";
	public static final String CUSTOMER_LOGIN = "CUSTOMER_LOGIN";

	/**
	 * Finds out if the admin login is expired or not.
	 *
	 * @param request http request.
	 * @return true if the admin is logged in and session is active, false
	 *         otherwise.
	 */
	public static boolean isAdminLoggedIn(final HttpServletRequest request) {

		final HttpSession session = request.getSession();
		if (session != null) {
			final Enumeration names = session.getAttributeNames();
			while (names.hasMoreElements()) {
				final String name = (String) names.nextElement();
				if (StringUtils.equals(name, ADMIN_LOGIN)) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean isCustomerLoggedIn(final HttpServletRequest request) {

		final HttpSession session = request.getSession();
		if (session != null) {
			final Enumeration names = session.getAttributeNames();
			while (names.hasMoreElements()) {
				final String name = (String) names.nextElement();
				if (StringUtils.equals(name, CUSTOMER_LOGIN)) {
					return true;
				}
			}
		}

		return false;
	}
}
