package com.olms.avalons.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.olms.avalons.entity.AdminEntity;

/**
 * Admin repo.
 *
 * @author Samba Chennamsetty
 * @since Apr 18, 2022
 */
@Repository
public interface AdminRepository
		extends CrudRepository<AdminEntity, Long>, PagingAndSortingRepository<AdminEntity, Long> {

	@Query(value = "SELECT * FROM loan.admin a WHERE a.email_id = :emailId and a.password = :password", nativeQuery = true)
	AdminEntity findByUserNameAndPassword(final String emailId, final String password);

}
