package com.callor.rent.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.callor.rent.models.RentBookDto;
import com.callor.rent.models.RentBookVO;
import com.callor.rent.service.RentBookService;

import lombok.extern.slf4j.Slf4j;

/*
 * localhost:8080/rent/rent 또는 localhost:8080/rent/rent/* 로 요청이 들어왔을때
 * Browser 에 주소를 입력하거나 nav 항목을 클릭 했을때
 * 
 * 서비스를 제공할 시작점이다.
 */

@Slf4j
@Controller
@RequestMapping(value = "/rent")
// 지금부터 별도 지시가 있을때까지 RENT_WORK 객체는 지우지 않는다
// 서버의 Session 영역에 영구 보관한다.
@SessionAttributes("RENT_WORK")
public class RentController {

	protected final RentBookService rentBookService;

	public RentController(RentBookService rentBookService) {
		this.rentBookService = rentBookService;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(Model model) {
		List<RentBookDto> rentbook = rentBookService.selectAll();
		model.addAttribute("RENT_WORK", rentbook);
		return "rent/home";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO) {
		return "rent/work_book";
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public String work_book(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO) {
		return "rent/work_member";
	}
	
	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public String work_member(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO) {
		return "rent/work_complete";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String work_complete(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO) {
		log.debug("전달된 데이터 {}", rentBookVO);
		return "redirect:/rent";
	}
	
	@ModelAttribute("RENT_WORK")
	public RentBookVO newRentBook() {
		return new RentBookVO();
	}
	
}
