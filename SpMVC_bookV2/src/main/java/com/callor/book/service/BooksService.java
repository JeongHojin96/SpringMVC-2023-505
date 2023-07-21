package com.callor.book.service;

import java.util.List;

import com.callor.book.model.BooksDto;

public interface BooksService {

	public List<BooksDto> selectAll();
	
	public BooksDto findByCode(String code);
	
	public List<BooksDto> findByNameAuther(String name);
	
	public int insert(BooksDto booksDto);
	
	public int update(BooksDto booksDto);
	
	public int secession(BooksDto booksDto);
	
	public BooksDto findTachoByCode(String Code);
	
}
