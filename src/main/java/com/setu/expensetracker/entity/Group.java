package com.setu.expensetracker.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "groups")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column(name = "group_name")
	@NotBlank
	private String groupName;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinTable(name = "group_user", joinColumns = { @JoinColumn(name = "group_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id") })
	private Set<User> users = new HashSet<>();

	public Group() {
		super();
	}

	public Group(String groupName) {
		super();
		this.groupName = groupName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void addUser(User user) {
		if (users.contains(user)) {
			return;
		}
		users.add(user);
		user.checkGroup(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
