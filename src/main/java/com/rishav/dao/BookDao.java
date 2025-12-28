package com.rishav.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.rishav.exception.BookIdNotFoundException;
import com.rishav.model.Book;
import com.rishav.repository.BookRepository;

@Repository
public class BookDao {
	
	@Autowired
	private BookRepository bookRepository;
	
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	
	public List<Book> addmultiplebooks(List<Book> books) {
		return bookRepository.saveAll(books);
	}
	
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book getBookById(Integer id) {
		Optional<Book> opt=bookRepository.findById(id);
		if(opt.isPresent())
			return opt.get();
		else
			throw new BookIdNotFoundException("Book not found!!");
		
	}
	
	public void deleteBook(Book book) {
		bookRepository.delete(book);
	}
	
	public List<Book> getBookByAuthor(String author) {
		return bookRepository.findByAuthorIgnoreCase(author);
	}
	
	public List<Book> getBookByGenre(String genre) {
		return bookRepository.findByGenreIgnoreCase(genre);
	}
	
	public List<Book> getBookByPublishedYear(Integer year) {
		return bookRepository.findByPublishedYear(year);
	}
	
	public Page<Book> getBookByPaginationAndSorting(Pageable p) {
		return bookRepository.findAll(p);
	}
}
