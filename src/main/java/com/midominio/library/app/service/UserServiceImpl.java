package com.midominio.library.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midominio.library.app.dao.IUserDao;
import com.midominio.library.app.entity.User;
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	public IUserDao userDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<User> findAll(){
		
		return userDao.findAll();
	}
	@Override
	@Transactional
	public void save(User user) {
		
		userDao.save(user);
	}
	@Override
	@Transactional(readOnly = true)
	public User findOne(Long id) {
		
		return userDao.findOne(id);
	}
	@Override
	@Transactional
	public void delete(Long id) {
		userDao.delete(id);
	}
}
