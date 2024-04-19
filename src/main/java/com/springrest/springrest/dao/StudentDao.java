package com.springrest.springrest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springrest.springrest.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {
	@Query("select s from Student s where s.id=?1")
	List<Student> getById(int id);
	@Query("select s from Student s where s.studentEmail=?1")
	List<Student> getByStudentEmail(String studentEmail);
	@Query("select s from Student s where s.studentPhoneNo=?1")
	List<Student> getByStudentPhoneNo(String studentPhoneNo);
	@Query("select s from Student s where s.userName=?1")
	List<Student> getByUserName(String userName);
	Student getReferenceByStudentEmail(String studentEmail);
	Student getReferenceByStudentPhoneNo(String studentPhoneNo);
	Student getReferenceByUserName(String userName);
	Student deleteByStudentEmail(String studentEmail);
	Student deleteByStudentPhoneNo(String studentPhoneNo);
	Student deleteByUserName(String userName);
	Optional<Student> findByStudentEmail(String studentEmail);
	Optional<Student> findByStudentPhoneNo(String studentPhoneNo);
	Optional<Student> findByUserName(String userName);
}
