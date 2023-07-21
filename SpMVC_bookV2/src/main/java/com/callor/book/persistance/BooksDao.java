package com.callor.book.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.book.model.BooksDto;

public interface BooksDao {

	@Select("select * from tbl_books")
	public List<BooksDto> selectAll();
	
	@Select("Select * from tbl_books where b_code = #{code}")
	public BooksDto findByCode(String code);
	
	public List<BooksDto> findByNameAuther(String name);
	
	public int insert(BooksDto booksDto);
	
	public int update(BooksDto booksDto);
	
	// 사용중지
	// 업데이트 기능을 통해 대여가격을 0으로 바꿈
	// 대출 유효성검사로 대여가격이 0이면 대여할 수 없도록 함
	public int secession(BooksDto booksDto);
	
	public BooksDto findTachoByCode(String code);
	
}
