package com.setu.expensetracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "expense_user")
public class UserExpense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column(name = "expense_id")
	private Integer expenseId;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column
	private float amount;
	
	@Column(name = "remaining_amount")
	private float remAmount;

	
	public UserExpense() {
		super();
	}

	public UserExpense(Integer userId, float amount, float remAmount) {
		super();
		this.userId = userId;
		this.amount = amount;
		this.remAmount = remAmount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getRemAmount() {
		return remAmount;
	}

	public void setRemAmount(float remAmount) {
		this.remAmount = remAmount;
	}
	
	
}
