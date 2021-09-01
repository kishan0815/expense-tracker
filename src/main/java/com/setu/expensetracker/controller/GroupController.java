package com.setu.expensetracker.controller;


import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setu.expensetracker.dto.GroupRequestDto;
import com.setu.expensetracker.dto.GroupResponseDto;
import com.setu.expensetracker.service.GroupService;

@RestController
@RequestMapping(value="/api/group")
public class GroupController {

	@Autowired
	GroupService groupService;
	
	@GetMapping("/{groupId}")
    public ResponseEntity<GroupResponseDto> getGroup(@PathVariable int groupId) {
		GroupResponseDto responseDto = groupService.getGroup(groupId);
    	if(responseDto != null) {
    		return new ResponseEntity<>(responseDto, HttpStatus.OK);
    	}
        throw new EntityNotFoundException("No Group found");
    }
    
	
	@PostMapping("/")
    public ResponseEntity<GroupResponseDto> addGroup(@RequestBody @Valid GroupRequestDto request) {
    	return new ResponseEntity<>(groupService.addGroup(request), HttpStatus.CREATED);
    }
}
