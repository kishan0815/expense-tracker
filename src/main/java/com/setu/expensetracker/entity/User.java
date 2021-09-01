package com.setu.expensetracker.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column
	@NotBlank
	private String username;

	@Column(name = "full_name")
	@NotBlank
	private String fullName;

	@Column
	@NotNull
	private Integer age;

	@ManyToMany(mappedBy = "users")
	private Set<Group> groups = new HashSet<>();

	public User() {
		super();
	}

	public User(Integer id) {
		super();
		this.id = id;
	}

	public User(@NotBlank String username, @NotBlank String fullName, @NotNull Integer age) {
		super();
		this.username = username;
		this.fullName = fullName;
		this.age = age;
	}

	public User(Integer id, @NotBlank String username, @NotBlank String fullName, @NotNull Integer age) {
		super();
		this.id = id;
		this.username = username;
		this.fullName = fullName;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
