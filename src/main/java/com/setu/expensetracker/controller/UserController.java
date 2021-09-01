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

import com.setu.expensetracker.dto.UserRequestDto;
import com.setu.expensetracker.dto.UserResponseDto;
import com.setu.expensetracker.service.UserService;

@RestController
@RequestMapping(value="/api/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable int userId) {
		UserResponseDto responseDto = userService.getUser(userId);
    	if(responseDto != null) {
    		return new ResponseEntity<>(responseDto, HttpStatus.OK);
    	}
        throw new EntityNotFoundException("No User found");
    }
    
	
	@PostMapping("/")
    public ResponseEntity<UserResponseDto> addUser(@RequestBody @Valid UserRequestDto request) {
    	return new ResponseEntity<>(userService.addUser(request), HttpStatus.CREATED);
    }
}
