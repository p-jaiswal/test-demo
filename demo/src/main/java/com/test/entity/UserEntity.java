package com.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "testdb")
@NamedQuery(query = "select u from UserEntity u where u.age=?1 and u.gender=?2", name = "query_find_all_users")
public class UserEntity {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "username", nullable = false)
	private String userName;

	@Column(name = "age", nullable = false)
	private int age;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "phone_no", nullable = false)
	private long phoneNo;

	public UserEntity() {
		super();
	}

	public UserEntity(String userName, int age, String gender, long phoneNo) {
		this.userName = userName;
		this.age = age;
		this.gender = gender;
		this.phoneNo = phoneNo;
	}

	public int getUserId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

}
