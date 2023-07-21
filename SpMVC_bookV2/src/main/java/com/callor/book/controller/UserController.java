package com.callor.book.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.book.model.BooksDto;
import com.callor.book.model.UsersDto;
import com.callor.book.service.UsersService;

@Controller
@RequestMapping
public class UserController {
	
	protected final UsersService userService;

	public UserController(UsersService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(@ModelAttribute("USER") UsersDto usersDto, Model model){
		List<UsersDto> usersList = userService.selectAll();
		model.addAttribute("USERS_LIST", usersList);
		return "user/insert";
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("BOOK") UsersDto usersDto) {
		userService.insert(usersDto);
		int result = userService.insert(usersDto);
		return "redirect:/";
	}
	
	@RequestMapping(value="/userlist", method=RequestMethod.GET)
	public String userlist (@ModelAttribute("USER")UsersDto usersDto, Model model) {
		List<UsersDto> usersList = userService.selectAll();
		model.addAttribute("USER_LIST", usersList);	
		return "book/userlist";
	}
	
}
