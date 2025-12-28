package com.rishav.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rishav.dao.BookDao;
import com.rishav.dto.BookDto;
import com.rishav.exception.BookIdNotFoundException;
import com.rishav.mapper.BookMapper;
import com.rishav.model.Book;
import com.rishav.resource.ResponseStructure;

@Service
public class BookServiceImpl implements BookService {

	private final BookDao bookDao;

	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public ResponseEntity<ResponseStructure<BookDto>> addBook(BookDto bookDto) {

		Book book = BookMapper.toEntity(bookDto);
		Book savedBook = bookDao.addBook(book);

		BookDto savedDto = BookMapper.toDto(savedBook);
		System.out.println("Book record saved successfully");

		ResponseStructure<BookDto> response = new ResponseStructure<BookDto>();
		response.setStatus(HttpStatus.CREATED.value());
		response.setMessage("Book succesfully added");
		response.setData(savedDto);

		return new ResponseEntity<ResponseStructure<BookDto>>(response, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<BookDto>>> addMultipleBooks(List<BookDto> bookDto) {
		List<Book> books = new ArrayList<Book>();
		for (BookDto dto : bookDto) {
			Book book = new Book();
			book.setTitle(dto.getTitle());
			book.setAuthor(dto.getAuthor());
			book.setGenre(dto.getGenre());
			book.setPublishedYear(dto.getPublishedYear());
			book.setPrice(dto.getPrice());
			book.setAvailableCopies(dto.getAvailableCopies());
			book.setTotalCopies(dto.getTotalCopies());

			books.add(book);
		}

		// Save to DB
		List<Book> savedBooks = bookDao.addmultiplebooks(books);

		// Entity -> DTO
		List<BookDto> responseDto = new ArrayList<BookDto>();
		for (Book book : savedBooks) {
			BookDto dto = new BookDto();
			dto.setId(book.getId());
			dto.setId(book.getId());
			dto.setAuthor(book.getAuthor());
			dto.setGenre(book.getGenre());
			dto.setPublishedYear(book.getPublishedYear());
			dto.setAvailableCopies(book.getAvailableCopies());
			dto.setTotalCopies(book.getTotalCopies());

			responseDto.add(dto);
		}

		ResponseStructure<List<BookDto>> response = new ResponseStructure<List<BookDto>>();
		response.setStatus(HttpStatus.CREATED.value());
		response.setMessage("Books succesfully added");
		response.setData(responseDto);

		return new ResponseEntity<ResponseStructure<List<BookDto>>>(response, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<BookDto>> updateBook(BookDto bookDto) {
		Book existingBook = bookDao.getBookById(bookDto.getId());

		if (existingBook == null) {
			throw new BookIdNotFoundException("Book not found with id " + bookDto.getId());
		}

		existingBook.setTitle(bookDto.getTitle());
		existingBook.setAuthor(bookDto.getAuthor());
		existingBook.setGenre(bookDto.getGenre());
		existingBook.setPublishedYear(bookDto.getPublishedYear());
		existingBook.setPrice(bookDto.getPrice());
		existingBook.setAvailableCopies(bookDto.getAvailableCopies());
		existingBook.setTotalCopies(bookDto.getTotalCopies());

		Book updatedBook = bookDao.updateBook(existingBook);
		BookDto updatedDto = BookMapper.toDto(updatedBook);

		System.out.println("Book record updated successfully");

		ResponseStructure<BookDto> response = new ResponseStructure<BookDto>();
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("Book record updated successfully");
		response.setData(updatedDto);

		return new ResponseEntity<ResponseStructure<BookDto>>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteBook(Integer id) {
		Book existingBook = bookDao.getBookById(id);

		if (existingBook == null) {
			throw new BookIdNotFoundException("Book not found with id " + id);
		}

		bookDao.deleteBook(existingBook);
		System.out.println("Book deleted sucessfully");

		ResponseStructure<String> response = new ResponseStructure<String>();
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("Book deletd sucessfully");
		response.setData("Delated sucessfull");

		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<BookDto>> getBookById(Integer id) {
		Book existingBook = bookDao.getBookById(id);

		if (existingBook == null) {
			throw new BookIdNotFoundException("Book not found with " + id + " id!!");
		}

		BookDto dto = new BookDto();
		dto.setId(existingBook.getId());
		dto.setTitle(existingBook.getTitle());
		dto.setAuthor(existingBook.getAuthor());
		dto.setGenre(existingBook.getGenre());
		dto.setPublishedYear(existingBook.getPublishedYear());
		dto.setPrice(existingBook.getPrice());
		dto.setAvailableCopies(existingBook.getAvailableCopies());
		dto.setTotalCopies(existingBook.getTotalCopies());

		ResponseStructure<BookDto> response = new ResponseStructure<BookDto>();
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("Book data retrived successfully!!");
		response.setData(dto);

		return new ResponseEntity<ResponseStructure<BookDto>>(response, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<BookDto>>> getBookByAuthor(String author) {
		List<Book> books = bookDao.getBookByAuthor(author);
		if (books.isEmpty()) {
			throw new BookIdNotFoundException("No books found for author: " + author);
		}

		List<BookDto> dtos = new ArrayList<BookDto>();
		for (Book book : books) {
			BookDto dto = BookMapper.toDto(book);
			dtos.add(dto);
		}

		ResponseStructure<List<BookDto>> response = new ResponseStructure<>();
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("Books retrieved successfully");
		response.setData(dtos);

		return new ResponseEntity<ResponseStructure<List<BookDto>>>(response, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<BookDto>>> getBookByGenre(String genre) {
		List<Book> books=bookDao.getBookByGenre(genre);
		if(books.isEmpty()) {
			throw new BookIdNotFoundException("No book found for genre "+genre);
		}
		
		List<BookDto> dtos=new ArrayList<BookDto>();
		for (Book book : books) {
			BookDto dto=BookMapper.toDto(book);
			dtos.add(dto);
		}
		
		ResponseStructure<List<BookDto>> response = new ResponseStructure<>();
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("Books retrieved successfully");
		response.setData(dtos);

		return new ResponseEntity<ResponseStructure<List<BookDto>>>(response, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<BookDto>>> getBookByPublishedYear(Integer year) {
		List<Book> books=bookDao.getBookByPublishedYear(year);
		if(books.isEmpty()) {
			throw new BookIdNotFoundException("No book found in published year "+year);
		}
		
		List<BookDto> dtos=new ArrayList<BookDto>();
		for (Book book : books) {
			BookDto dto=BookMapper.toDto(book);
			dtos.add(dto);
		}
		
		ResponseStructure<List<BookDto>> response = new ResponseStructure<>();
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("Books retrieved successfully");
		response.setData(dtos);

		return new ResponseEntity<ResponseStructure<List<BookDto>>>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<Page<BookDto>>> getBookByPeginationAndSorting(Integer page, Integer size, String sortByField) {
		Pageable pageable=PageRequest.of(page, size, Sort.by(sortByField).ascending());
		
		Page<Book> bookPage=bookDao.getBookByPaginationAndSorting(pageable);
		if(bookPage.isEmpty()) {
			throw new BookIdNotFoundException("No book found!!!");
		}
		
		List<BookDto> dtoList = new ArrayList<>();
		for(Book book : bookPage.getContent()) {
			BookDto dto = new BookDto();
			dto.setId(book.getId());
			dto.setTitle(book.getTitle());
			dto.setAuthor(book.getAuthor());
			dto.setGenre(book.getGenre());
			dto.setPublishedYear(book.getPublishedYear());
			dto.setAvailableCopies(book.getAvailableCopies());
			dto.setTotalCopies(book.getTotalCopies());

			dtoList.add(dto);
		}
	    Page<BookDto> dtoPage = new PageImpl<BookDto>(dtoList, pageable, bookPage.getTotalElements());
		
		ResponseStructure<Page<BookDto>> response = new ResponseStructure<>();
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("Books retrieved successfully");
		response.setData(dtoPage);

		return new ResponseEntity<ResponseStructure<Page<BookDto>>>(response, HttpStatus.OK);
	}
}
