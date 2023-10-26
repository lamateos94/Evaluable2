package com.midominio.library.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.midominio.library.app.entity.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class BookDaoImpl implements IBookDao{

	@PersistenceContext
	private EntityManager em;
	
	public List<Book> findAll(){
		
		return em.createQuery("From Book", Book.class).getResultList();
		
	}
	

	@Override
	@Transactional (readOnly=true)
	public Book findOne(Long id) {
		
		return em.find(Book.class, id);
	}
	@Override
	@Transactional
	public List<Book> findByAuthor(String authorFilter) {
	    return em.createQuery("SELECT b FROM Book b WHERE b.author = :author", Book.class)
	             .setParameter("author", authorFilter)
	             .getResultList();
	}



	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}
}