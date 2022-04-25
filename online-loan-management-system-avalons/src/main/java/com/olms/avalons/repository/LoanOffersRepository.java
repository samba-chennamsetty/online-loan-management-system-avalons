package com.olms.avalons.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.olms.avalons.entity.LoanOffersEntity;
import com.olms.avalons.model.LoanOffers;

/**
 * Loan offers repository
 *
 * @author Samba Chennamsetty
 * @since Apr 18, 2022
 */
@Repository
@Transactional
public interface LoanOffersRepository extends JpaRepository<LoanOffersEntity, Long> {

	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO loan_offers (amount, interest, loan_name, loan_range) values (:#{#loanOffer.amount}, :#{#loanOffer.interest}, :#{#loanOffer.loanName}, :#{#loanOffer.loanRange})", nativeQuery = true)
	void saveloanOffer(@Param("loanOffer") final LoanOffers loanOffer);

	@Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
	Long findLastInsertedId();

	@Query(value = "SELECT * FROM loan_offers;", nativeQuery = true)
	List<LoanOffersEntity> findAllLoanOffers();

	@Query(value = "SELECT * FROM loan_offers lo WHERE lo.loan_id = :id", nativeQuery = true)
	LoanOffersEntity findByLoanId(final Long id);

	@Modifying
	@Query(value = "DELETE FROM loan.loan_offers lo WHERE lo.loan_id = :id", nativeQuery = true)
	void deleteById(final Long id);

	@Modifying
	@Query(value = "UPDATE loan_offers lo SET lo.amount = :#{#loanOffer.amount}, lo.interest = :#{#loanOffer.interest}, lo.loan_name = :#{#loanOffer.loanName}, lo.loan_range = :#{#loanOffer.loanRange} WHERE lo.loan_id = :#{#loanOffer.loanId}", nativeQuery = true)
	void updateLoanOffer(final LoanOffers loanOffer);
}
