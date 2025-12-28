package com.rishav.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.rishav.dto.BookDto;
import com.rishav.resource.ResponseStructure;

public interface BookService {
	public ResponseEntity<ResponseStructure<BookDto>> addBook(BookDto bookDto);
	public ResponseEntity<ResponseStructure<BookDto>> updateBook(BookDto bookDto);
	public ResponseEntity<ResponseStructure<String>> deleteBook(Integer id);
	public ResponseEntity<ResponseStructure<BookDto>> getBookById(Integer id);
	public ResponseEntity<ResponseStructure<List<BookDto>>> addMultipleBooks(List<BookDto> bookDto);
	public ResponseEntity<ResponseStructure<List<BookDto>>> getBookByAuthor(String author);
	public ResponseEntity<ResponseStructure<List<BookDto>>> getBookByGenre(String genre);
	public ResponseEntity<ResponseStructure<List<BookDto>>> getBookByPublishedYear(Integer year);
	public ResponseEntity<ResponseStructure<Page<BookDto>>> getBookByPeginationAndSorting(Integer page, Integer size, String sortByField);
}
