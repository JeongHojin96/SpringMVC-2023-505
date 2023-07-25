package com.callor.rent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.rent.models.RentBookDto;

public interface RentBookDao {

	@Select("select * from tbl_rentbook order by rent_date")
	public List<RentBookDto> selectAll();
	
	@Select("select * from tbl_rentbook where rent_seq = #{id}")
	public RentBookDto findById(long id);
	
	public List<RentBookDto> findByBCode(String bcode);
	public List<RentBookDto> findByMcode(String mcode);
	
	public int insert(RentBookDto dto);
	public int update(RentBookDto dto);
	
	public void create_rent_book_table(String dumy);
}
