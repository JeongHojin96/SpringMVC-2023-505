package com.callor.dample.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.callor.dample.model.BoardDto;

public interface BoardDao {

	@Select("select * from tbl_board order by b_seq")
	public List<BoardDto> selectAll();
	
	@Select("select * "
			+ " from tbl_board "
			+ " where b_seq = #{seq} ")
	public BoardDto findBySeq(String seq);
	
	@Select("select b_password from tbl_board "
			+ " where b_seq = #{seq} ")
	public BoardDto findPW(long seq);
	
	public int insert(BoardDto btDto);
	
	public int countup(BoardDto btDto);
	
	public int update(BoardDto btDto);
	
	public int delete(BoardDto btDto);
	
	@Select("select * from tbl_board "
			+ " where b_ccode = #{cate} "
			+ " order by b_seq ")
	public List<BoardDto> findByCate(String cate);
	
	@Select("select * from tbl_board "
			+ " where b_nickname = #{nick} "
			+ " order by b_seq ")
	public List<BoardDto> findByNick(String nick);
	
	@Select("select * from tbl_board "
			+ " where b_content = #{content} "
			+ " order by b_seq ")
	public List<BoardDto> findByContent(String content);
	
	
	
	
}
