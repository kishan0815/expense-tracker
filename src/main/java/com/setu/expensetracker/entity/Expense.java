package com.setu.expensetracker.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "expense")
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column(name = "group_id")
	private Integer groupId;

	@Column(name = "paid_user_id")
	private Integer paidUserId;

	@Column
	private float amount;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "expense_id")
	List<UserExpense> userExpense;

	public Expense() {
		super();
	}

	public Expense(Integer groupId, Integer paidUserId, float amount, List<UserExpense> userExpense) {
		super();
		this.groupId = groupId;
		this.paidUserId = paidUserId;
		this.amount = amount;
		this.userExpense = userExpense;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getPaidUserId() {
		return paidUserId;
	}

	public void setPaidUserId(Integer paidUserId) {
		this.paidUserId = paidUserId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public List<UserExpense> getUserExpense() {
		return userExpense;
	}

	public void setUserExpense(List<UserExpense> userExpense) {
		this.userExpense = userExpense;
	}


}
