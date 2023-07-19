package com.callor.car.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.car.models.CarDto;

public interface CarDao {
	@Select(" select * from tbl_car order by c_seq ")
	public List<CarDto> selectAll();
	
	public List<CarDto> findUserSelectLimit();
	
	@Select(" select * from tbl_car where c_seq = #{seq} ")
	public CarDto findByseq(String seq);
	
	public int insert(CarDto carDto);
}
