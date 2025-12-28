package com.rishav.mapper;


import com.rishav.dto.BookDto;
import com.rishav.model.Book;

public class BookMapper {
	
	//Entity -> DTO
	public static BookDto toDto(Book book) {
		if(book==null)
			return null;
		
		BookDto dto=new BookDto();
		dto.setTitle(book.getTitle());
		dto.setAuthor(book.getAuthor());
		dto.setGenre(book.getGenre());
		dto.setPrice(book.getPrice());
		dto.setPublishedYear(book.getPublishedYear());
		dto.setAvailableCopies(book.getAvailableCopies());
		dto.setTotalCopies(book.getTotalCopies());
		
		return dto;
	}
	
	//DTO -> Entity
	public static Book toEntity(BookDto dto) {
        if (dto == null) return null;

        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setGenre(dto.getGenre());
        book.setPrice(dto.getPrice());
        book.setPublishedYear(dto.getPublishedYear());
        book.setAvailableCopies(dto.getAvailableCopies());
        book.setTotalCopies(dto.getTotalCopies());

        return book;
    }
}
