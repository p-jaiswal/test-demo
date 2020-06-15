package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.UserDTO;
import com.test.entity.UserEntity;
import com.test.services.UserService;

/**
 * @author PrashantJaiswal
 * @param  userService
 *
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/create-all-user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createUsers(@RequestBody List<UserDTO> userDto) throws Exception{
		String userDetails = userService.saveUserDetails(userDto);
		return new ResponseEntity<String>(userDetails, HttpStatus.OK);
	}

	@GetMapping(value = "/get-userdetails/{age}/{gender}")
	public ResponseEntity<List<UserEntity>> getDetailByAgeAndGender(@PathVariable int age, @PathVariable String gender) throws Exception{
		List<UserEntity> getUserDetails = userService.getDetailByAgeAndGender(age,gender);
		return new ResponseEntity<List<UserEntity>>(getUserDetails, HttpStatus.OK);
	}

}
