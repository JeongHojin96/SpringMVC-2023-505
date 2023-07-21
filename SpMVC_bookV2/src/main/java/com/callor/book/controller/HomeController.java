package com.callor.book.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.book.model.BooksDto;
import com.callor.book.service.BooksService;

@Controller
@RequestMapping
public class HomeController {

	protected final BooksService booksService;

	public HomeController(BooksService booksService) {
		this.booksService = booksService;
	}
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(@ModelAttribute("BOOK") BooksDto booksDto, Model model){
		List<BooksDto> booksList = booksService.selectAll();
		model.addAttribute("BOOKS_LIST", booksList);
		return "book/insert";
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("BOOK") BooksDto booksDto) {
		booksService.insert(booksDto);
		int result = booksService.insert(booksDto);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<BooksDto> booksList = booksService.selectAll();
		model.addAttribute("BOOK_LIST", booksList);		
		return "home";
	}
	
	
	@RequestMapping(value="/booklist", method=RequestMethod.GET)
	public String booklist (@ModelAttribute("BOOK")BooksDto booksDto, Model model) {
		List<BooksDto> booksList = booksService.selectAll();
		model.addAttribute("BOOK_LIST", booksList);	
		return "book/booklist";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String serch(@ModelAttribute("BOOK")String name, Model model) {
		List<BooksDto> booksList = booksService.findByNameAuther(name);
		model.addAttribute("BOOK_LIST", booksList);
		return "book/booklist";
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/book_check", method=RequestMethod.GET)
	public BooksDto findTachoByCode(String code) {
		BooksDto booksDto = booksService.findTachoByCode(code);
		if(booksDto==null) {
			booksDto = booksDto.builder().b_code("NOT").build();
		}
		return booksDto;
	}


}
