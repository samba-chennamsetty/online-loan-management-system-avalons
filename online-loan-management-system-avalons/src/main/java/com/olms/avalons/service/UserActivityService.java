/**
 * 
 */
package com.olms.avalons.service;

import java.util.List;

import com.olms.avalons.model.UserActivity;

/**
 * User activity service that process services related to user activity.
 *
 * @author Samba Chennamsetty
 * @since Jun 8, 2022
 */
public interface UserActivityService {

	void saveUserActivity(final String activityType, final Long customerId);

	List<UserActivity> getActivitiesByCustomerId(final Long customerId);
}
