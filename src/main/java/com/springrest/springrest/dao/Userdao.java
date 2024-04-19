package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entity.User;

public interface Userdao extends JpaRepository<User, Integer> {
	public User findByUserNameAndPassword(String userName,String password);
}
