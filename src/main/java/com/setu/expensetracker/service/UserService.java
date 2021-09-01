package com.setu.expensetracker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.setu.expensetracker.dto.UserRequestDto;
import com.setu.expensetracker.dto.UserResponseDto;
import com.setu.expensetracker.entity.User;
import com.setu.expensetracker.exception.InsertionException;
import com.setu.expensetracker.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public UserResponseDto getUser(Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			User userEntity = user.get();
			return new UserResponseDto(userEntity.getId(), userEntity.getUsername(), userEntity.getFullName(),
					userEntity.getAge());
		}
		return null;
	}

	public UserResponseDto addUser(UserRequestDto userRequest) {
		User user = new User(userRequest.getUsername(), userRequest.getFullName(), userRequest.getAge());
		user = userRepository.save(user);
		if (user.getId() != null) {
			return new UserResponseDto(user.getId(), user.getUsername(), user.getFullName(),
					user.getAge());
		}
		throw new InsertionException("QUIZ_INSERTION_FAILED");
	}

}
