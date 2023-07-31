package com.callor.dample.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.dample.config.QualifierConfig;
import com.callor.dample.model.BoardDto;
import com.callor.dample.model.FileDto;
import com.callor.dample.persistance.BoardDao;
import com.callor.dample.persistance.FileDao;
import com.callor.dample.service.BoardService;
import com.callor.dample.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/review")
public class ReviewController {

	protected final BoardService boardService;
	protected final FileService fileService;

	private final FileDao fileDao;

	public ReviewController(BoardService boardService,
			@Qualifier(QualifierConfig.SERVICE.FILE_V2) FileService fileService, FileDao fileDao) {
		this.boardService = boardService;
		this.fileService = fileService;
		this.fileDao = fileDao;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(Model model) {
		List<BoardDto> boardList = boardService.selectAll();
		model.addAttribute("WRITES", boardList);
		return "review/home";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String insert(@ModelAttribute("WRITE") BoardDto boardDto) {
		return "review/write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String insert(
			@ModelAttribute("WRITE") BoardDto boardDto,
			MultipartHttpServletRequest b_images, Model model) {

		try {

			if (b_images.getFile("b_images").getSize() > 0) {
				List<FileDto> files = fileService.filesUp(b_images);
				fileDao.insertfile(files, boardDto.getB_seq());
			}
			int result = boardService.insert(boardDto);
			return "redirect:/review";
		} catch (Exception e) {
//			e.printStackTrace();
			String message = e.getMessage();
			model.addAttribute("MESSAGE", message);
			return "review/write";
		}

	}

	@RequestMapping(value = "/{b_seq}/detail", method = RequestMethod.GET)
	public String detail(@PathVariable("b_seq") String bseq, BoardDto boardDto, Model model) {
		int result = boardService.viewcountup(boardDto);
		boardDto = boardService.findBySeq(bseq);
		model.addAttribute("WRITE", boardDto);
		List<FileDto> files = fileDao.findByBSeq(boardDto.getB_seq());
		model.addAttribute("BBS", boardDto);
		model.addAttribute("FILES", files);
		return "review/detail";
	}

	@RequestMapping(value = "/image_delete", method = RequestMethod.GET)
	public String image_delete(String seq) {

		/*
		 * 파일정보를 SELECT 하고 물리적 파일을 삭제하고 파일정보 데이터 삭제
		 */
		long seqNum = Long.valueOf(seq);
		FileDto fileDto = fileDao.findByid(seqNum);
		fileService.delete(fileDto.getI_uploadName());
		int result = fileDao.deletefile(seqNum);
		return "redirect:/review/detail?seq=" + fileDto.getI_bseq();
	}

	@RequestMapping(value = "/{b_seq}/update", method = RequestMethod.GET)
	public String update(@PathVariable("b_seq") String bseq, Model model) {
		BoardDto boardDto = boardService.findBySeq(bseq);
		model.addAttribute("WRITE", boardDto);
		model.addAttribute("STATE", "UPDATE");
		return "review/write";
	}

	@RequestMapping(value = "/{b_seq}/update", method = RequestMethod.POST)
	public String update(@PathVariable("b_seq") String bseq,
			MultipartHttpServletRequest b_images, @ModelAttribute("WRITE") BoardDto boardDto, Model model) {
		String fileName = null;
		try {
			int result = boardService.update(boardDto);
			if (b_images.getFile("b_images").getSize() > 0) {
				List<FileDto> files = fileService.filesUp(b_images);
				fileDao.insertfile(files, boardDto.getB_seq());// , bbsDto.getB_seq());
			}
			return "redirect:/review/{b_seq}/detail";

		} catch (Exception e) {
			e.printStackTrace();
			String message = e.getMessage();
			model.addAttribute("MESSAGE", message);
			return "review/write";
		}
	}

	@RequestMapping(value = "/{b_seq}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("b_seq") String bseq) {
		return "review/delete";
	}

	@RequestMapping(value = "/{b_seq}/delete", method = RequestMethod.POST)
	public String delete(@PathVariable("b_seq") String bseq, @ModelAttribute("WRITE") BoardDto boardDto, Model model) {
		try {
			int result = boardService.delete(boardDto);
		} catch (Exception e) {
			e.printStackTrace();
			String message = e.getMessage();
			model.addAttribute("MESSAGE", message);
			return "review/delete";
		}
		return "redirect:/review";
	}

	@ModelAttribute("WRITE")
	public BoardDto boardDto() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy.MM.dd HH:mm");
		String strDate = dateFormat.format(date);

		BoardDto boardDto = BoardDto.builder().b_date(strDate).build();

		return boardDto;
	}

}
