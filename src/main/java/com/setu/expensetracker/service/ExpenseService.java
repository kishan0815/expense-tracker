package com.setu.expensetracker.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.setu.expensetracker.dto.BalanceResponseDto;
import com.setu.expensetracker.dto.ExpenseDto;
import com.setu.expensetracker.dto.GenericResponseDto;
import com.setu.expensetracker.dto.ResolveExpenseDto;
import com.setu.expensetracker.dto.UserShareDto;
import com.setu.expensetracker.entity.Expense;
import com.setu.expensetracker.entity.UserExpense;
import com.setu.expensetracker.exception.InsertionException;
import com.setu.expensetracker.repository.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;

	public GenericResponseDto addExpense(ExpenseDto expenseDto) {
		List<UserExpense> userExpenses = expenseDto.getUserShare().stream()
				.map(ue -> new UserExpense(ue.getUserId(), ue.getAmount(), ue.getAmount()))
				.collect(Collectors.toList());
		Expense expense = new Expense(expenseDto.getGroupId(), expenseDto.getPaidUserId(), expenseDto.getAmount(),
				userExpenses);
		expense = expenseRepository.save(expense);
		if (expense.getId() != null) {
			return new GenericResponseDto("Expense created successfully with id: " + expense.getId());
		}
		throw new InsertionException("EXPENSE_INSERTION_FAILED");
	}

	public Expense resolveExpense(ResolveExpenseDto requestDto) {
		Optional<Expense> expenseOpt = expenseRepository.findById(requestDto.getExpenseId());
		if (expenseOpt.isPresent()) {
			Expense expense = expenseOpt.get();
			List<UserExpense> userExpenses = expense.getUserExpense();
			userExpenses.stream().forEach(exp -> {
				if (exp.getUserId().equals(requestDto.getUserId())) {
					exp.setRemAmount((exp.getAmount() - requestDto.getAmount() < 0) ? 0
							: exp.getAmount() - requestDto.getAmount());
				}
			});
			return expenseRepository.save(expense);
		} 
		throw new EntityNotFoundException("EXPENSE_NOT_FOUND");
	}

	public BalanceResponseDto getBalance(int userId) {
		Map<Integer, Float> balanceMap = new HashMap<>();
		List<Object[]> positiveBalances = expenseRepository.findPositiveBalanceData(userId);
		List<Object[]> negativeBalances = expenseRepository.findNegativeBalanceData(userId);
		for(Object[] iter : positiveBalances) {
			Integer tempUserId = (Integer) iter[0];
			Double remAmount = (Double) iter[1];
			balanceMap.computeIfPresent(tempUserId, (key, val) -> (float)(val  +  remAmount));
			balanceMap.computeIfAbsent(tempUserId, k -> remAmount.floatValue());
		}
		
		for(Object[] iter : negativeBalances) {
			Integer tempUserId = (Integer) iter[0];
			Double remAmount = (Double) iter[1];
			balanceMap.computeIfPresent(tempUserId, (key, val) -> (float)(val  -  remAmount));
			balanceMap.computeIfAbsent(tempUserId, k -> -remAmount.floatValue());
		}
		
		
		return computeBalanceResponseDto(userId, balanceMap);
	}

	private BalanceResponseDto computeBalanceResponseDto(int userId, Map<Integer, Float> balanceMap) {
		BalanceResponseDto balance = new BalanceResponseDto();
		balance.setUserId(userId);
		balance.setBalances(new ArrayList<>());
		float netBalance = 0;
		for(Map.Entry<Integer, Float> entry : balanceMap.entrySet()) {
			balance.getBalances().add(new UserShareDto(entry.getKey(), entry.getValue()));
			netBalance += entry.getValue();
		}
		balance.setNetAmount(netBalance);
		return balance;
	}

}
