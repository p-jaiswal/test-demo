package com.test.serviceImpl;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import com.test.dao.UserRepository;
import com.test.dto.UserDTO;
import com.test.entity.UserEntity;

@RunWith(MockitoJUnitRunner.class)
public class ServiceImplTest {
	private static final ModelMapper modelMapper = new ModelMapper();
	
	@InjectMocks
    UserServiceImpl testServiceImpl;
	
	@Mock
	UserRepository testRepository;
	
	@Mock
	EntityManager entityManager;
	
	@Mock
    Query query;
	
	 @Test
	    public void saveTest() throws Exception { 
		 List<UserDTO> testlist = new LinkedList<UserDTO>();
		 UserDTO testDto = new UserDTO(1, "abc", 30, "Male", 12345);
		 UserDTO testDto1 = new UserDTO(2, "cde", 35, "Female", 67891);
		 UserDTO testDto2 = new UserDTO(3, "abc", 30, "Male", 12345);
		 UserDTO testDto3 = new UserDTO(4, "cde", 35, "Female", 67891);
		 testlist.add(testDto);
		 testlist.add(testDto1);
		 testlist.add(testDto2);
		 testlist.add(testDto3);
	         
		 testServiceImpl.saveUserDetails(testlist);
		 
		  UserEntity testDb = modelMapper.map(testlist, UserEntity.class);  
	      verify(testRepository, times(1)).save(testDb);
	    }
	 
	 @Test
	 public void getDetailByAgeAndGenderTest() throws Exception {
		 List<UserEntity> testlist = new LinkedList<UserEntity>();
		 UserEntity testDb = new UserEntity("demo", 30, "Male", 10101010);
		 UserEntity testDb1 = new UserEntity("demo1", 35, "Female", 20202020);
		 UserEntity testDb2 = new UserEntity("demo2", 30, "Male", 30303030);
		 testlist.add(testDb);
		 testlist.add(testDb1);
		 testlist.add(testDb2);
		 
		 when(entityManager.createNamedQuery("query_find_all_users")).thenReturn(query);
		 when(query.getSingleResult()).thenReturn(testlist);
		 List<UserEntity> getDetailByAgeAndGender = testServiceImpl.getDetailByAgeAndGender(30, "Male");
		 assertSame(testlist, getDetailByAgeAndGender);	
		}	
}
