package com.callor.dample.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.dample.model.BoardTestDto;
import com.callor.dample.service.BoardTestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/review")
public class ReviewController {
	
	protected final BoardTestService boardService;
	
	public ReviewController(BoardTestService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(Model model) {
		List<BoardTestDto> boardList = boardService.selectAll();
		model.addAttribute("WRITES", boardList);
		return "review/home";
	}
	
	@RequestMapping(value = "/write",method = RequestMethod.GET)
	public String insert(@ModelAttribute("WRITE") BoardTestDto boardDto) {
		return "review/write";
	}
	
	@RequestMapping(value = "/write",method = RequestMethod.POST)
	public String insert(@ModelAttribute("WRITE") BoardTestDto boardDto, Model model) {
		int result = boardService.insert(boardDto);		
		return "redirect:/review";
	}
	
	@RequestMapping(value = "/{b_seq}/detail", method = RequestMethod.GET)
	public String detail(@PathVariable("b_seq") String bseq, Model model) {
		BoardTestDto boardDto = boardService.findBySeq(bseq);
		model.addAttribute("WRITE", boardDto);
		return "review/detail";
	}
	
	@RequestMapping(value = "/{b_seq}/update", method = RequestMethod.GET)
	public String update(@PathVariable("b_seq") String bseq, Model model) {
		BoardTestDto boardDto = boardService.findBySeq(bseq);
		model.addAttribute("WRITE", boardDto);
		return "review/write";
	}
	
	@RequestMapping(value = "/{b_seq}/update", method = RequestMethod.POST)
	public String update(@PathVariable("b_seq")String bseq, @ModelAttribute("WRITE")BoardTestDto boardDto, Model model ) {
		if(!bseq.isBlank())
			boardDto.setB_seq(Integer.valueOf(bseq));
		int result = boardService.update(boardDto);
		return "review/write";
	}
	
	
	
	
	
}
