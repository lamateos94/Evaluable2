package com.midominio.library.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.midominio.library.app.entity.User;
@Service
public interface IUserService {
	
	List<User> findAll();
	void save(User user);
	User findOne(Long id);
	void delete(Long id);

}
