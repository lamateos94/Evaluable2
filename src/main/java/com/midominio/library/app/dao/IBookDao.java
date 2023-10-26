package com.midominio.library.app.dao;

import java.util.List;



import com.midominio.library.app.entity.Book;

public interface IBookDao {

	List<Book> findAll();
	public Book saveBook(Book book);
	Book findOne(Long id);
	List<Book> findByAuthor(String authorFilter);
}
