package com.callor.rent.service;

import java.util.List;

import com.callor.rent.models.BookDto;

public interface BookService {

	public List<BookDto> selectAll();

	public int insert(BookDto bookDto);

	public BookDto findByID(String bcode);

	public int update(BookDto bookDto);


}
