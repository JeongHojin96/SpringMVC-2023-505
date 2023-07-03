package com.callor.address.service.impl;

import org.springframework.stereotype.Service;

import com.callor.address.models.UserDto;
import com.callor.address.service.UserService;

@Service
public class UserServiceImplV1 implements UserService {

	public UserDto findById(String id) {
		return null;
	}

	public String userLogin(UserDto userDto) {
		
		String username = userDto.getUsername();
		String password = userDto.getPassword();
		if(!username.equalsIgnoreCase("callor")) {
			return "F_USERNAME";
		} else if(!password.equals("!aa1234")) {
			return "F_PASSWORD";
		} else {
			return "OK";
		}		
	}

	public int userJoin(UserDto userDto) {
		return 0;
	}

}
