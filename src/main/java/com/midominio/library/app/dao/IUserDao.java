package com.midominio.library.app.dao;

import java.util.List;

import com.midominio.library.app.entity.User;

public interface IUserDao {

	List<User> findAll();
	
	void save(User user);
	User findOne(Long id);
	void delete(Long id);
}
