package com.callor.book.service;

import java.util.List;

import com.callor.book.model.UsersDto;

public interface UsersService {
	
	public List<UsersDto> selectAll();
		
	public UsersDto findByCode(String code);
	
	public int inset(UsersDto userDto);
	
	public int update(UsersDto userDto);
	
	public int secession(UsersDto userDto);
	
}
