package com.callor.book.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.book.model.UsersDto;

public interface UsersDao {

	@Select("select * from tbl_users")
	public List<UsersDto> selectAll();
		
	@Select("Select * from tbl_users where u_code = #{code}")
	public UsersDto findByCode(String code);
	
	public int inset(UsersDto userDto);
	
	public int update(UsersDto userDto);
	
	// 회원탈퇴
	// 업데이트 기능을 통해 ID를 탈퇴한 회원으로 표기
	// 비밀번호를 공란으로 바꾸고 로그인 유효성검사로 공란은 로그인 하지 못하는것을 이용
	public int secession(UsersDto userDto);
	
}
