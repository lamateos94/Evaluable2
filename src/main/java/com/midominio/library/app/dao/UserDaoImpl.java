package com.midominio.library.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.midominio.library.app.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UserDaoImpl implements IUserDao {
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<User> findAll(){
	
	return em.createQuery("from User", User.class).getResultList();
}
	
	@Override
	public void save(User user) {
	if(user.getId() != null && user.getId()>0) {
			
			em.merge(user);
		}else
		em.persist(user);
	}
		
	
	
	@Override
	
	public User findOne(Long id) {
		
		return em.find(User.class, id);
	}
	@Override
	
	public void delete(Long id) {
		em.remove(findOne(id));
	}
	}
