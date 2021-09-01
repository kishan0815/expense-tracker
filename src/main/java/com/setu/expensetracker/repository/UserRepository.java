package com.setu.expensetracker.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.setu.expensetracker.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
