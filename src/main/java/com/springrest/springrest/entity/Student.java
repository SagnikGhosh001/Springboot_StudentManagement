package com.springrest.springrest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;





@Entity
@Table(name = "register_Student")
public class Student extends User {
	@Column(name = "name")
	@javax.validation.constraints.NotNull
	private String studentName;
	@Column(name = "phoneNo",unique = true)
	@javax.validation.constraints.NotNull
	private String studentPhoneNo;
	@Column(name = "email",unique = true)
	@javax.validation.constraints.NotNull
	private String studentEmail;
	@Column(name = "gender")
	@javax.validation.constraints.NotNull
	private String gender;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String userName, String password, String role) {
		super(id, userName, password, role);
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String userName, String password, String role, @javax.validation.constraints.NotNull String studentName,
			@javax.validation.constraints.NotNull String studentPhoneNo, @javax.validation.constraints.NotNull String studentEmail, @javax.validation.constraints.NotNull String gender) {
		super(id, userName, password, role);
		this.studentName = studentName;
		this.studentPhoneNo = studentPhoneNo;
		this.studentEmail = studentEmail;
		this.gender = gender;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentPhoneNo() {
		return studentPhoneNo;
	}
	public void setStudentPhoneNo(String studentPhoneNo) {
		this.studentPhoneNo = studentPhoneNo;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentPhoneNo=" + studentPhoneNo + ", studentEmail="
				+ studentEmail + ", gender=" + gender + "]";
	}
	
		
	/**
	 * @param id
	 * @param userName
	 * @param password
	 * @param role
	 * @param studentName
	 * @param studentPhoneNo
	 * @param studentEmail
	 */

	
	
	
	
}
	