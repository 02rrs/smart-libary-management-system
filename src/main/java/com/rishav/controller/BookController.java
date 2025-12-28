package com.rishav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rishav.dto.BookDto;
import com.rishav.resource.ResponseStructure;
import com.rishav.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<BookDto>> addBook(@RequestBody BookDto bookDto) {
		return bookService.addBook(bookDto);
	}
	
	@PostMapping("/bulk")
	public ResponseEntity<ResponseStructure<List<BookDto>>> addMultipleBooks(@RequestBody List<BookDto> bookDtos) {
	    return bookService.addMultipleBooks(bookDtos);
	}

	
	@PostMapping("/update/{id}")
	public ResponseEntity<ResponseStructure<BookDto>> updateBook(@PathVariable int id, @RequestBody BookDto bookDto) {
		bookDto.setId(id);
		return bookService.updateBook(bookDto);
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteBook(@PathVariable int id) {
		return bookService.deleteBook(id);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ResponseStructure<BookDto>> getBookById(@PathVariable int id) {
		return bookService.getBookById(id);
	}
	
	@GetMapping("/geta/{author}")
	public ResponseEntity<ResponseStructure<List<BookDto>>> getBookByAuthor(@PathVariable String author) {
		return bookService.getBookByAuthor(author);
	}
	
	@GetMapping("/getg/{genre}")
	public ResponseEntity<ResponseStructure<List<BookDto>>> getBookByGenre(@PathVariable String genre) {
		return bookService.getBookByGenre(genre);
	}
	
	@GetMapping("/gety/{year}")
	public ResponseEntity<ResponseStructure<List<BookDto>>> getBookByGenre(@PathVariable Integer year) {
		return bookService.getBookByPublishedYear(year);
	}
	
	@GetMapping("/pagenation")
	public ResponseEntity<ResponseStructure<Page<BookDto>>> getBookByPaginationAndSorting(@RequestParam int page, @RequestParam int size, @RequestParam String sortByField) {
		return bookService.getBookByPeginationAndSorting(page, size, sortByField);
	}
}
