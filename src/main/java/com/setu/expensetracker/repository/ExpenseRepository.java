package com.setu.expensetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.setu.expensetracker.entity.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Integer> {

	@Query(value = "SELECT exu.user_id, exu.remaining_amount FROM EXPENSE AS ex "
			+ "INNER JOIN EXPENSE_USER AS exu ON ex.id =exu.expense_id "
			+ "WHERE exu.remaining_amount > 0 AND ex.paid_user_id = :userId", nativeQuery = true)
	List<Object[]> findPositiveBalanceData(Integer userId);

	@Query(value = "SELECT ex.paid_user_id, exu.remaining_amount FROM EXPENSE AS ex "
			+ "INNER JOIN EXPENSE_USER AS exu ON ex.id =exu.expense_id "
			+ "WHERE exu.remaining_amount > 0 AND exu.user_id = :userId", nativeQuery = true)
	List<Object[]> findNegativeBalanceData(Integer userId);
}
