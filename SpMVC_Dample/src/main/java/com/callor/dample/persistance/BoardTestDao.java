package com.callor.dample.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.dample.model.BoardTestDto;

public interface BoardTestDao {

	@Select("select * from tbl_boardtest order by b_seq")
	public List<BoardTestDto> selectAll();
	
	@Select("select * from tbl_boardtest "
			+ " where b_seq = #{seq} ")
	public BoardTestDto findBySeq(String seq);
	
	public int insert(BoardTestDto btDto);
	
	public int update(BoardTestDto btDto);
	
	public int delete(BoardTestDto btDto);
	
	@Select("select * from tbl_boardtest "
			+ " where b_ccode = #{cate} "
			+ " order by b_seq ")
	public List<BoardTestDto> findByCate(String cate);
	
	@Select("select * from tbl_boardtest "
			+ " where b_nickname = #{nick} "
			+ " order by b_seq ")
	public List<BoardTestDto> findByNick(String nick);
	
	@Select("select * from tbl_boardtest "
			+ " where b_content = #{content} "
			+ " order by b_seq ")
	public List<BoardTestDto> findByContent(String content);
	
}
