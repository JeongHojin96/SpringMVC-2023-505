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
import com.callor.dample.model.BoardTestDto;
import com.callor.dample.persistance.BoardTestDao;
import com.callor.dample.service.BoardTestService;
import com.callor.dample.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/review")
public class ReviewController {

	protected final BoardTestService boardService;
	protected final FileService fileService;

	private final BoardTestDao boardDao;

	public ReviewController(BoardTestService boardService,
			@Qualifier(QualifierConfig.SERVICE.FILE_V2)
			FileService fileService, BoardTestDao boardDao) {
		this.boardService = boardService;
		this.fileService = fileService;
		this.boardDao = boardDao;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(Model model) {
		List<BoardTestDto> boardList = boardService.selectAll();
		model.addAttribute("WRITES", boardList);
		return "review/home";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String insert(@ModelAttribute("WRITE") BoardTestDto boardDto) {
		return "review/write";
	}

	@RequestMapping(value = "/write",method = RequestMethod.POST)
	public String insert(@ModelAttribute("WRITE") BoardTestDto boardDto,
			// 싱글파일 업로드용
			@RequestParam(value="b_file") MultipartFile b_file,
			// 멀티파일 업로드용
			// @ReqeustParam 부착 금지 400 오류 발생
			MultipartHttpServletRequest b_images, Model model) {
		String fileName = null;
		try {
			if( !b_file.getOriginalFilename().isEmpty() ) {
			fileName = fileService.fileUp(b_file);
			boardDto().setB_image(fileName);
			}
			int result = boardService.insert(boardDto);
			
			if(b_images.getFile("b_images").getSize() > 0) {
				List<BoardTestDto> files = fileService.filesUp(b_images);
			   boardDao.insertfile(files,boardDto.getB_seq()) ; // , bbsDto.getB_seq());
			}
			return "redirect:/review";
		} catch (Exception e) {
			e.printStackTrace();
			String message = e.getMessage();
			model.addAttribute("MESSAGE", message);
			log.debug("파일을 업로드 할수 없음 오류 발생!!");
			return "redirect:/write?error=FILE_UP_ERROR";
		}
	
	}

	@RequestMapping(value = "/{b_seq}/detail", method = RequestMethod.GET)
	public String detail(@PathVariable("b_seq") String bseq, BoardTestDto boardDto, Model model) {
		int result = boardService.viewcountup(boardDto);
		boardDto = boardService.findBySeq(bseq);
		model.addAttribute("WRITE", boardDto);
		List<BoardTestDto> files = boardDao.findByBSeq(boardDto.getB_seq());
		model.addAttribute("BBS",boardDto);
		model.addAttribute("FILES",files);
		return "review/detail";
	}
	
	@RequestMapping(value="/image_delete" ,method=RequestMethod.GET)
	public String image_delete(String seq) {
		
		/*
		 * 파일정보를 SELECT 하고
		 * 물리적 파일을 삭제하고
		 * 파일정보 데이터 삭제
		 */
		long seqNum = Long.valueOf(seq);
		BoardTestDto fileDto = boardDao.findByid(seqNum);
		fileService.delete(fileDto.getI_uploadName());
		int result = boardDao.deletefile(seqNum);
		return "redirect:/review/detail?seq=" + fileDto.getB_seq();
	}
	
	

	@RequestMapping(value = "/{b_seq}/update", method = RequestMethod.GET)
	public String update(@PathVariable("b_seq") String bseq, Model model) {
		BoardTestDto boardDto = boardService.findBySeq(bseq);
		model.addAttribute("WRITE", boardDto);
		model.addAttribute("STATE", "UPDATE");
		return "review/write";
	}

	@RequestMapping(value = "/{b_seq}/update", method = RequestMethod.POST)
	public String update(@PathVariable("b_seq") String bseq,
			// 싱글파일 업로드용
			@RequestParam(value="b_file") MultipartFile b_file,
			// 멀티파일 업로드용
			// @ReqeustParam 부착 금지 400 오류 발생
			MultipartHttpServletRequest b_images,
			@ModelAttribute("WRITE") BoardTestDto boardDto, Model model) {
		String fileName = null;
		try {
			if( !b_file.getOriginalFilename().isEmpty() ) {
				fileName = fileService.fileUp(b_file);
				boardDto().setB_image(fileName);
				}
			int result = boardService.update(boardDto);
			if(b_images.getFile("b_images").getSize() > 0) {
				List<BoardTestDto> files = fileService.filesUp(b_images);
			   boardDao.insertfile(files,boardDto.getB_seq()) ; // , bbsDto.getB_seq());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			String message = e.getMessage();
			model.addAttribute("MESSAGE", message);
			return "review/write";
		}
		return "redirect:/review/{b_seq}/detail";
	}

	@RequestMapping(value = "/{b_seq}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("b_seq") String bseq) {
		return "review/delete";
	}

	@RequestMapping(value = "/{b_seq}/delete", method = RequestMethod.POST)
	public String delete(@PathVariable("b_seq") String bseq, @ModelAttribute("WRITE") BoardTestDto boardDto,
			Model model) {
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
	public BoardTestDto boardDto() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy.MM.dd HH:mm");
		String strDate = dateFormat.format(date);

		BoardTestDto boardDto = BoardTestDto.builder().b_date(strDate).build();

		return boardDto;
	}

}
