package com.callor.bbs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.bbs.models.UserDto;
import com.callor.bbs.repository.UserRepository;
import com.callor.bbs.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImplV1 implements UserService{

	private final UserRepository userDao;
	public UserServiceImplV1(UserRepository userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public UserDto join(UserDto userDto) {
		// TODO Auto-generated method stub
		
		long userCount = userDao.count();
		log.debug("사용자정보 Count: {}", userCount);
		
		// 최초에 등록되는 사용자는 ADMIN 이면서 USER 이다
		List<String> grantList = new ArrayList<>();
		if(userCount < 1) grantList.add("ADMIN");
		grantList.add("USER");
		
		return null;
	}

	@Override
	public UserDto findByID(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
