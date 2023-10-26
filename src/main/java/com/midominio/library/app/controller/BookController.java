package com.midominio.library.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.midominio.library.app.dao.IBookDao;
import com.midominio.library.app.entity.Book;


@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private IBookDao bookDao;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		model.addAttribute("title", "Book list");
		model.addAttribute("list", bookDao.findAll() );
		
		return "book/book-list";
	}
	@GetMapping("/filter")
	public String listByAuthor(@RequestParam("authorFilter") String authorFilter, Model model) {
		List<Book> booksByAuthor = bookDao.findByAuthor(authorFilter);
		model.addAttribute("title", "Author List:" + authorFilter);
		model.addAttribute("list", booksByAuthor);
		
		
		return "/book/book-list";
	}
}
