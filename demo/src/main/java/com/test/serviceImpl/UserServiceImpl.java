package com.test.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.UserRepository;
import com.test.dto.UserDTO;
import com.test.entity.UserEntity;
import com.test.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public String saveUserDetails(List<UserDTO> userDto) throws Exception{
		String response = "User records are added successfully";
		UserEntity userEntity = new UserEntity();
		for (UserDTO userDetail : userDto) {
			userEntity.setId(userDetail.getId());
			userEntity.setUserName(userDetail.getUserName());
			userEntity.setAge(userDetail.getAge());
			userEntity.setGender(userDetail.getGender());
			userEntity.setPhoneNo(userDetail.getPhoneNo());
			userRepository.save(userEntity);
		}
		return response;
		}

	@Override
	public List<UserEntity> getDetailByAgeAndGender(int age, String gender) throws Exception{
		Query query = entityManager.createNamedQuery("query_find_all_users", UserEntity.class);
		query.setParameter(1, age);
		query.setParameter(2, gender);
		List<UserEntity> getUserDetails = query.getResultList();
		return getUserDetails;
	}
}
