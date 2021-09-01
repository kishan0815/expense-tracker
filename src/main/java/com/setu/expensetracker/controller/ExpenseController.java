package com.setu.expensetracker.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setu.expensetracker.dto.BalanceResponseDto;
import com.setu.expensetracker.dto.ExpenseDto;
import com.setu.expensetracker.dto.GenericResponseDto;
import com.setu.expensetracker.dto.ResolveExpenseDto;
import com.setu.expensetracker.entity.Expense;
import com.setu.expensetracker.service.ExpenseService;

@RestController
@RequestMapping(value="/api/expense")
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	@PutMapping("/")
    public ResponseEntity<Expense> resolveExpense(@RequestBody @Valid ResolveExpenseDto request) {
        return new ResponseEntity<>(expenseService.resolveExpense(request), HttpStatus.OK);
    }
    
	
	@PostMapping("/")
    public ResponseEntity<GenericResponseDto> addExpense(@RequestBody @Valid ExpenseDto expense) {
    	return new ResponseEntity<>(expenseService.addExpense(expense), HttpStatus.CREATED);
    }
	
	@GetMapping("/{userId}")
    public ResponseEntity<BalanceResponseDto> getBalances(@PathVariable int userId) {
    	return new ResponseEntity<>(expenseService.getBalance(userId), HttpStatus.OK);
    }
}
