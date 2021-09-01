package com.setu.expensetracker.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.setu.expensetracker.dto.GroupRequestDto;
import com.setu.expensetracker.dto.GroupResponseDto;
import com.setu.expensetracker.entity.Group;
import com.setu.expensetracker.entity.User;
import com.setu.expensetracker.exception.InsertionException;
import com.setu.expensetracker.repository.GroupRepository;

@Service
public class GroupService {

	@Autowired
	GroupRepository groupRepository;

	public GroupResponseDto getGroup(Integer groupId) {
		Optional<Group> group = groupRepository.findById(groupId);
		if (group.isPresent()) {
			Group groupEntity = group.get();
			return new GroupResponseDto(groupEntity.getId(), groupEntity.getGroupName(),
					groupEntity.getUsers().stream().map(User::getId).collect(Collectors.toList()));
		}
		return null;
	}

	public GroupResponseDto addGroup(GroupRequestDto groupRequest) {
		Group grp = new Group(groupRequest.getName());
		for (int userId : groupRequest.getUserIds()) {
			User user = new User(userId);
			grp.getUsers().add(user);
		}
		grp = groupRepository.save(grp);
		if (grp.getId() != null) {
			return new GroupResponseDto(grp.getId(), grp.getGroupName(),
					grp.getUsers().stream().map(User::getId).collect(Collectors.toList()));
		}
		throw new InsertionException("GROUP_INSERTION_FAILED");
	}

}
