package com.callor.dample.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.callor.dample.model.BoardTestDto;

public interface BoardTestDao {

	@Select("select * from tbl_boardtest order by b_seq")
	public List<BoardTestDto> selectAll();
	
	@Select("select b_seq, "
			+ "b_title, "
			+ "b_content, "
			+ "b_icode, "
			+ "b_nickname, "
			+ "b_ccode, "
			+ "b_date, "
			+ "b_viewcount from tbl_boardtest "
			+ " where b_seq = #{seq} ")
	public BoardTestDto findBySeq(String seq);
	
	@Select("select b_password from tbl_boardtest "
			+ " where b_seq = #{seq} ")
	public BoardTestDto findPW(long seq);
	
	public int insert(BoardTestDto btDto);
	
	public int insertfile(
			@Param("list") List<BoardTestDto> files,
			@Param("b_seq") long b_seq 
			);
	
	public int countup(BoardTestDto btDto);
	
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
	
	
	// 게시판과 연결할때 사용할 method
		@Select("SELECT i_uploadName, i_originalName FROM tbl_boardtest WHERE b_seq = #{b_seq}")
		public List<BoardTestDto> findByBSeq(long b_seq);
		
		@Select("SELECT i_uploadName, i_originalName FROM tbl_boardtest WHERE b_seq = #{id}")
		public BoardTestDto findByid(long id);
		
		@Delete("DELETE FROM tbl_boardtest WHERE b_seq = #{seqNum}")
		public int deletefile(long seqNum);
	
}
