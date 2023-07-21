package com.callor.book.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.book.model.BooksDto;
import com.callor.book.persistance.BooksDao;
import com.callor.book.service.BooksService;

@Service
public class BooksServiceImplV1 implements BooksService {
	
	protected final BooksDao booksDao;
		
	public BooksServiceImplV1(BooksDao booksDao) {
		this.booksDao = booksDao;
	}

	public List<BooksDto> selectAll() {
		return booksDao.selectAll();
	}

	public BooksDto findByCode(String code) {
		BooksDto booksDto = booksDao.findByCode(code);		
		
		return booksDto;				
	}

	public List<BooksDto> findByNameAuther(String name) {
		List<BooksDto> bookslist = booksDao.findByNameAuther(name);
		return bookslist;
	}

	public int insert(BooksDto booksDto) {
		int result = booksDao.insert(booksDto);
		return result;
	}

	public int update(BooksDto booksDto) {
		int result = booksDao.update(booksDto);
		return result;
	}

	public int secession(BooksDto booksDto) {
		int result = booksDao.secession(booksDto);
		return result;
	}

	public BooksDto findTachoByCode(String Code) {
		return booksDao.findTachoByCode(Code);
	}


}
