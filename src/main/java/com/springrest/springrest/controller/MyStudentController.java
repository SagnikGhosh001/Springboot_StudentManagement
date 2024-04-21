package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.Student;
import com.springrest.springrest.services.StudentService;

@RestController
@RequestMapping("/student")
public class MyStudentController {
	
	@Autowired
	StudentService obj_studentService;
	
	@GetMapping("/AllStudents")
	public List<Student> getStudents(){
		return obj_studentService.getStudents();
	}
	@GetMapping("/StudentbyId/{id}")
	public List<Student> getStudent(@PathVariable String id){
		return obj_studentService.getStudent(Integer.parseInt(id));
	}
	@PostMapping("/AddStudent")
	public ResponseEntity<?> addStudent(@RequestBody Student student){
		
			this.obj_studentService.addStudent(student);
			return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/UpdateStudents/{id}/{role}")
	public String updateStudent(@PathVariable("role") String role,@PathVariable("id") int id,@RequestBody Student student){
		if(role.equals("admin")) {
			return this.obj_studentService.updateStudent(id,student);
		}
		else {
			return "you are not admin";
		}
	}
	
	@PutMapping("/ForgetPassword/{email}")
	public ResponseEntity<?> forgetPassword(@PathVariable("email") String email,@RequestBody Student password){
		
			this.obj_studentService.forgetPassword(email,password);
			return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@DeleteMapping("/DeleteStudent/{id}/{role}")
	public String deleteStudent(@PathVariable("role") String role,@PathVariable String id){
		if(role.equals("admin")) {
			return this.obj_studentService.deleteStudent(Integer.parseInt(id));
		}
		else {
			return "You are not Admin";
		}
		
	}
	@GetMapping("/StudentbystudentEmail/{studentEmail}")
	public List<Student> getStudentBystudentEmail(@PathVariable String studentEmail){
		return obj_studentService.getStudentBystudentEmail(studentEmail);
	}
	@GetMapping("/StudentbystudentPhoneNo/{studentPhoneNo}")
	public List<Student> getStudentBystudentPhoneNo(@PathVariable String studentPhoneNo){
		return obj_studentService.getStudentBystudentPhoneNo(studentPhoneNo);
	}
	@GetMapping("/StudentbystudentUserName/{userName}")
	public List<Student> getStudentBystudentUserName(@PathVariable String userName){
		return obj_studentService.getStudentBystudentUserName(userName);
	}
}
