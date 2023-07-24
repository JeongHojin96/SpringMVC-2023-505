package com.callor.rent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.rent.models.BookDto;

public interface BookDao {
		@Select("select * from tbl_books order by b_name")
		public List<BookDto> selectAll();
		
		@Select("Select * from tbl_books where b_code = #{id}")
		public BookDto findById(String id);
		
		public int insert(BookDto bookDto);
		public int update(BookDto bookDto);
		
		@Select("select * from tbl_books "
				+ " where b_name like concat('%',#{name},'%' ) "
				+ " order by b_name ")
		public List<BookDto> findByBName(String name);
		
		@Select("select * from tbl_books "
				+ " where b_comp like concat('%',#{comp},'%' ) "
				+ " order by b_comp ")
		public List<BookDto> findByBComp(String comp);
		
		@Select("select * from tbl_books "
				+ " where b_auther like concat('%',#{auther},'%' ) "
				+ " order by b_auther ")
		public List<BookDto> findByBAutohr(String author);
	
		public void create_book_table(String dumy);
	
		
		
}
