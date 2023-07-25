package com.callor.rent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.callor.rent.models.MemberDto;

public interface MemberDao {

	@Select("select * from tbl_members order by m_name")
	public List<MemberDto> selectAll();
	
	@Select("select * from tbl_members where m_code = #{id}")
	public MemberDto findByid(String id);
	
	@Select("select max(m_code) from tbl_members")
	public String getMaxMCode();
	
	public int insert(MemberDto memberDto);
	
	public int update(MemberDto memberDto);
	
	@Select("select * from tbl_members "
			+ " where m_tel like concat('%',#{name},'%' "
			+ " order by m_name")
	public List<MemberDto> findByName(String name);
	
	@Select("select * from tbl_members "
			+ " where m_tel like concat('%',#{tel},'%' "
			+ " order by m_tel")
	public List<MemberDto> findByTel(String tel);
	
	@Select("select * from tbl_members "
			+ " where m_tel like concat('%',#{addr},'%' "
			+ " order by m_addr")
	public List<MemberDto> findByAddr(String addr);

	public void create_member_table(String dumy);

	@Select("select * from tbl_members "
			+ " where m_name = #{name} AND m_tel = #{tel} ")
	public MemberDto findNameAndTel(
			@Param("name") String name, @Param("tel") String tel);
	
}
