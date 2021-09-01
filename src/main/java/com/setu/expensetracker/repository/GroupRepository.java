package com.setu.expensetracker.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.setu.expensetracker.entity.Group;

@Repository
public interface GroupRepository extends CrudRepository<Group, Integer> {

}
