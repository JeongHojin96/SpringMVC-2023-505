package com.callor.car.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.car.model.CarDto;

public interface CarDao {
	@Select(" select * from tbl_carmanager order by c_seq ")
	public List<CarDto> selectAll();
	
	public List<CarDto> findUserSelectLimit();
	
	@Select(" select * from tbl_carmanager where c_seq = #{seq} ")
	public CarDto findByseq(String seq);
	
	public int insert(CarDto carDto);
	
	public CarDto findTachoByCarNum(String carnum);
}
