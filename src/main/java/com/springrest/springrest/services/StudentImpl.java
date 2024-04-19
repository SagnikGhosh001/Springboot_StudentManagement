package com.springrest.springrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.exceptions.ResourceNotFoundException;
import com.springrest.springrest.dao.StudentDao;
import com.springrest.springrest.entity.Student;

@Service
public class StudentImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;
	@Override
	public List<Student> getStudents() {
		return studentDao.findAll();
	}

	@Override
	public List<Student> getStudent(int id) {
		studentDao.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Student", "id", id));
		return studentDao.getById(id);
		
	}

	@Override
	public String updateStudent(int id,Student student) {
		String msg=null;
		Student existStudent=studentDao.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Student", "id", id));
		existStudent.setUserName(student.getUserName());
		existStudent.setPassword(student.getPassword());
		existStudent.setRole(student.getRole());
		existStudent.setStudentEmail(student.getStudentEmail());
		existStudent.setStudentName(student.getStudentName());
		existStudent.setStudentPhoneNo(student.getStudentPhoneNo());
		existStudent.setGender(student.getGender());
		studentDao.save(existStudent);
		msg="updated";
		return msg;
		
	}

	@Override
	public void addStudent(Student student) {
		studentDao.save(student);
		
	}

	@Override
	public String deleteStudent(int id) {
		String msg=null;
		Optional<Student> opPass=studentDao.findById(id);
		if(opPass.isPresent()) {
			studentDao.deleteById(id);
			msg="Record deleted sucessfully";
		}	
		else {
			new ResourceNotFoundException("Student","id",id);
		}
		return msg;
	}

	@Override
	public List<Student> getStudentBystudentEmail(String studentEmail) {
		studentDao.findByStudentEmail(studentEmail).orElseThrow(()->
		new ResourceNotFoundException("Student", "email", studentEmail));
		return studentDao.getByStudentEmail(studentEmail);
	}

	@Override
	public List<Student> getStudentBystudentPhoneNo(String studentPhoneNo) {
		studentDao.findByStudentPhoneNo(studentPhoneNo).orElseThrow(()->
		new ResourceNotFoundException("Student", "phoneNo", studentPhoneNo));
		return studentDao.getByStudentPhoneNo(studentPhoneNo);
	}

	@Override
	public List<Student> getStudentBystudentUserName(String userName) {
		studentDao.findByUserName(userName).orElseThrow(()->
		new ResourceNotFoundException("Student", "userName", userName));
		return studentDao.getByUserName(userName);
	}

	@Override
	public void forgetPassword(String email, Student passoword) {
		Student existstudent=studentDao.findByStudentEmail(email).orElseThrow(()->
				new ResourceNotFoundException("Student", "email", email));
		existstudent.setPassword(passoword.getPassword());
		studentDao.save(existstudent);
	}

	

}
