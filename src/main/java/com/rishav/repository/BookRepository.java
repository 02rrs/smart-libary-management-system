package com.rishav.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishav.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	public Book findBookById(Integer id);
	public List<Book> findByAuthorIgnoreCase(String author);
	public List<Book> findByGenreIgnoreCase(String genre);
	public List<Book> findByPublishedYear(Integer publishedYear);
}
