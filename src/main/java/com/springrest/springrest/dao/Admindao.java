package com.springrest.springrest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springrest.springrest.entity.Admin;


public interface Admindao extends JpaRepository<Admin, Integer> {
	
	@Query("select a from Admin a where a.adminEmail=?1")
	List<Admin> getByAdminEmail(String adminEmail);
	@Query("select a from Admin a where a.adminPhoneNo=?1")
	List<Admin> getByAdminPhoneNo(String adminPhoneNo);
	@Query("select a from Admin a where a.userName=?1")
	List<Admin> getByUserName(String userName);
	@Query("select a from Admin a where a.id=?1")
	List<Admin> getById(int id);
	Admin getReferenceByAdminEmail(String adminEmail);
	Admin getReferenceByUserName(String userName);
	Admin getReferenceByAdminPhoneNo(String phoneNo);
	Optional<Admin> findByAdminPhoneNo(String adminPhoneNo);
	Optional<Admin> findByUserName(String userName);
	Optional<Admin> findByAdminEmail(String adminEmail);

}
