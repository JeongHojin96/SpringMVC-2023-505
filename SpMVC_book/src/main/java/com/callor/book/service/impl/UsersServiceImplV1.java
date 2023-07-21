package com.callor.book.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.book.model.UsersDto;
import com.callor.book.persistance.UsersDao;
import com.callor.book.service.UsersService;
@Service
public class UsersServiceImplV1 implements UsersService{

	protected final UsersDao usersDao;
	
	public UsersServiceImplV1(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public List<UsersDto> selectAll() {
		
		return usersDao.selectAll();
	}

	public UsersDto findByCode(String code) {
		UsersDto usersDto = usersDao.findByCode(code);
		return usersDto;
	}

	public int inset(UsersDto userDto) {
		int result = usersDao.inset(userDto);
		return result;
	}

	public int update(UsersDto userDto) {
		int result = usersDao.update(userDto);
		return result;
	}

	public int secession(UsersDto userDto) {
		int result = usersDao.secession(userDto);
		return result;
	}

}
