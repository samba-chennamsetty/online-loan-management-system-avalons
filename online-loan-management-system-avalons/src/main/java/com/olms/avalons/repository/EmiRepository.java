/**
 * 
 */
package com.olms.avalons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.olms.avalons.entity.EmiEntity;
import com.olms.avalons.model.Emi;

/**
 * Emi Repository that communicates with emi table.
 *
 * @author Samba Chennamsetty
 * @since Jun 5, 2022
 */
@Repository
public interface EmiRepository extends JpaRepository<EmiEntity, Long> {

	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO emi (period, payment_date, payment, current_balance, status, info_id, customer_id) values (:#{#emi.period}, :#{#emi.paymentDate}, :#{#emi.payment}, :#{#emi.currentBalance}, :#{#emi.status}, :#{#emi.loanInfoId},:#{#emi.customerId})", nativeQuery = true)
	void saveEmi(@Param("emi") final Emi emi);

	@Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
	Long findLastInsertedId();
}
