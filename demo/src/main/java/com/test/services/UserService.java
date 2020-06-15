package com.test.services;

import java.util.List;

import com.test.dto.UserDTO;
import com.test.entity.UserEntity;

public interface UserService {
	
	String saveUserDetails(List<UserDTO> userDto) throws Exception;

	List<UserEntity> getDetailByAgeAndGender(int age, String gender) throws Exception;
}
