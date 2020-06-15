package com.test.dto;

public class UserDTO {

	private int id;
	private String userName;
	private int age;
	private String gender;
	private long phoneNo;

	public UserDTO() {
		super();
	}

	public UserDTO(int id, String userName, int age, String gender, long phoneNo) {
		super();
		this.id = id;
		this.userName = userName;
		this.age = age;
		this.gender = gender;
		this.phoneNo = phoneNo;
	}

	public int getId() {
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
